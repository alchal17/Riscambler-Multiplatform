package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.rememberWindowState
import translator.DecodedInstruction
import translator.Decoder
import translator.Encoder
import translator.encodeCodeLine

object EncoderDecoderWindow {

    private val encoder = Encoder()
    private val decoder = Decoder()
    val isOpened = mutableStateOf(false)
    private val currentCode = mutableStateOf("")
    private val currentOutput = mutableStateOf("")

    @Composable
    private fun TopBar() {
        Column {
            TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
                Button({
                    currentOutput.value = ""
                    currentCode.value.lines().filter { it.isNotEmpty() }.forEach { line ->

                        if (line.all { char -> char.isDigit() }) {
                            val opcode = decoder.retrieveOpcode(line)
                            val functs = decoder.retrieveFuncts(line)
                            val operands = decoder.retrieveOperands(line)
                            val instructionName = decoder.retrieveInstructionName(opcode, functs)

                            val decoderInstruction = DecodedInstruction(instructionName, operands)

//                            currentOutput.value.append(decoderInstruction.toString()).append("\n")
                            currentOutput.value = "${currentOutput.value}$decoderInstruction\n"
                        } else {
                            val lineComponents = encoder.splitIntoComponents(line)
                            val encodedLine = encodeCodeLine(lineComponents)
//                            output.append(encodedLine).append("\n")
                            currentOutput.value = "${currentOutput.value}$encodedLine\n"
//                            memory.write(currentAddressPointer++, encodedLine.toUInt(2))
                        }

                    }
                }) { Text("Convert") }
            }
            Spacer(modifier = Modifier.fillMaxWidth().height(2.dp).background(color = Color.Black))
        }
    }

    @Composable
    fun WindowContent() {
        Window(
            title = "Encoder/Decoder",
            onCloseRequest = { isOpened.value = false },
            state = rememberWindowState(placement = WindowPlacement.Maximized)
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = { TopBar() },
                backgroundColor = MainBG
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        TextField(
                            modifier = Modifier.fillMaxHeight().weight(1f),
                            value = currentCode.value,
                            onValueChange = { currentCode.value = it })
                        Box(modifier = Modifier.weight(1f)) {
                            Text(currentOutput.value)
                        }
                    }
                }
            }
        }
    }
}