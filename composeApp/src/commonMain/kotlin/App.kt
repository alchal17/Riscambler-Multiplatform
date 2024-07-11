import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.MainBG
import ui.screens.MainScreen


@Composable
@Preview
fun App() {
    MaterialTheme(colors = darkColors()) {
        Box(modifier = Modifier.fillMaxSize().background(color = MainBG)) {
            MainScreen()
        }
    }
}