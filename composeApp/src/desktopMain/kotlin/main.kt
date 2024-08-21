import androidx.compose.ui.window.*
import ui.EncoderDecoderWindow


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Riscambler",
        state = rememberWindowState(placement = WindowPlacement.Maximized)
    ) {
        App()
        if (EncoderDecoderWindow.isOpened.value) {
            EncoderDecoderWindow.WindowContent()
        }
    }
}