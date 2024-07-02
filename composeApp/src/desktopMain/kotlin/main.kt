import androidx.compose.ui.window.*


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Riscambler",
        state = rememberWindowState(placement = WindowPlacement.Maximized)
    ) {
        App()
    }
}