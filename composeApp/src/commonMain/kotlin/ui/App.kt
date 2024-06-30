import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.DarkBackgroundColor
import ui.elements.ModeCard


@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize().background(DarkBackgroundColor), contentAlignment = Alignment.Center) {
            Row(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.5f),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.weight(1f)) { ModeCard("Classic") {} }
                Spacer(modifier = Modifier.weight(1f))
                Box(modifier = Modifier.weight(1f)) { ModeCard("Reading") {} }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}