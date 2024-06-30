package ui.elements

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ModeCard(text: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxSize()
            .clip(shape = RoundedCornerShape(8.dp)), onClick = onClick, backgroundColor = Color.Red
    ) { Text(text) }
}