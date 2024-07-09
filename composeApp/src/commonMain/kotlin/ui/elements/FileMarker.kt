package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import assembly_files_logic.AssemblyFile

@Composable
fun FileMarker(file: AssemblyFile, onClick: () -> Unit, bgColor: Color, onCrossClick: () -> Unit) {
    val cornerSize = 8.dp
    Box(
        modifier = Modifier.clip(shape = RoundedCornerShape(topStart = cornerSize, topEnd = cornerSize))
            .background(color = bgColor).clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = Modifier.padding(start = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Text(
                file.fileName,
                style = TextStyle(color = Color.White)
            )
            Spacer(modifier = Modifier.width(3.dp))
            IconButton(onCrossClick) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(15.dp)
                )
            }
        }
    }
}
