package ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import assembly_files_logic.OpenedAssemblyFiles
import memory.Memory
import memory.Registers
import memory.Registers.registers
import processing_tools.*
import riscambler_mutliplatform.composeapp.generated.resources.Res
import riscambler_mutliplatform.composeapp.generated.resources.debug
import riscambler_mutliplatform.composeapp.generated.resources.processor
import riscambler_mutliplatform.composeapp.generated.resources.run
import translator.Encoder
import translator.encodeCodeLine
import ui.MainBG
import ui.elements.MainPageBody
import ui.elements.MainTopBar
import ui.elements.topAppBarOptions


@Composable
fun MainScreen() {
    val memory = Memory(1024, 1024)
    val regs = Registers

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MainBG,
        topBar = {
            MainTopBar(
                topBarOptions = topAppBarOptions,
                iconButtons = listOf(
                    Pair(Res.drawable.run) {
                        //Deal with user's code on button click here
                        val userCode = OpenedAssemblyFiles.currentFileContent.lines().filter { it.isNotBlank() }
                        val sectionedCode = splitCodeInSections(userCode)
                        println(sectionedCode)

                        val dataSection = sectionedCode[".data:"]!!
                        val splitDataSection = splitDataSection(dataSection)
                        println(splitDataSection)

                        val textSection = sectionedCode[".text:"]!!
                        val splitTextSection = splitTextSection(textSection)
                        println(splitTextSection)


                        val encoder = Encoder()
                        // write .text to memory
                        val textLayout = mutableMapOf<String, Int>()
                        var codeEnd = 0
                        for ((key, value) in splitTextSection) {
                            for (instruction in value) {
                                val components = encoder.splitIntoComponents(instruction)
                                val encodedInstruction = encodeCodeLine(components)
                                val uintInstruction = convertToDecimal(encodedInstruction).toUInt()
                                memory.writeInstruction(uintInstruction)
                            }
                            val currentTextPointer = memory.getTextPointer()
                            textLayout[key] = currentTextPointer
                            codeEnd = currentTextPointer
                        }

                        memory.showTextContent()

                        var pc = 0
                        while (true) {
                            val instruction = memory.fetchInstruction(pc)
                            if (pc >= codeEnd) {
                                break
                            }
                            //val decodedInstruction = decodeInstruction(instruction)
                            processInstruction(instruction, memory, regs, pc)
                            pc += 4
                        }
                        //Check if UI refreshes after writing a new data to register
                        for (i in 0..<registers.size / 2) {
                            Registers.write(i, i)
                        }
                    },
                    Pair(Res.drawable.debug) {},
                    Pair(Res.drawable.processor) {}
                )
            )
        }) { paddingValues ->
        Box(modifier = Modifier.padding(top = paddingValues.calculateTopPadding())) {
            MainPageBody()
        }
    }
}