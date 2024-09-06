package ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import assembly_files_logic.OpenedAssemblyFiles
import riscambler_mutliplatform.composeapp.generated.resources.Res
import riscambler_mutliplatform.composeapp.generated.resources.debug
import riscambler_mutliplatform.composeapp.generated.resources.processor
import riscambler_mutliplatform.composeapp.generated.resources.run
import ui.MainBG
import ui.elements.MainPageBody
import ui.elements.MainTopBar
import ui.elements.topAppBarOptions


@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MainBG,
        topBar = {
            MainTopBar(
                topBarOptions = topAppBarOptions,
                iconButtons = listOf(
                    Pair(Res.drawable.run) {
                        //Deal with user's code on button click here
                        OpenedAssemblyFiles.currentFileContent.lines().filter { it.isNotBlank() }.forEach { codeLine ->
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