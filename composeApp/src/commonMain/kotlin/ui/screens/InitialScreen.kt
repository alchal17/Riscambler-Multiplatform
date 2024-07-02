package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import ui.DarkBackgroundColor
import ui.elements.ModeCard

class InitialScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        Box(contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.weight(1f)) { ModeCard("Classic") { navigator?.push(CodeScreen()) } }
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.weight(1f)) { ModeCard("Reading") {navigator?.push(ReadingScreen())} }
                Spacer(modifier = Modifier.weight(1f))
            }
        }

    }
}
