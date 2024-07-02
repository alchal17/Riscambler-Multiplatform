package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import riscambler_mutliplatform.composeapp.generated.resources.Res
import riscambler_mutliplatform.composeapp.generated.resources.keys
import ui.SecondaryBG
import ui.interactions.isIconTinted

@Composable
fun MainTopBar(topBarOptions: List<String>, iconButtons: List<Pair<DrawableResource, () -> Unit>>) {
    Column {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(Res.drawable.keys),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.padding(horizontal = 3.dp)
                    )
                    topBarOptions.forEach { topBarOption ->
                        Box(
                            modifier = Modifier.width(100.dp).fillMaxHeight()
                                .padding(vertical = 4.dp, horizontal = 6.dp).background(color = SecondaryBG),
                            contentAlignment = Alignment.Center
                        ) { Text(topBarOption, style = TextStyle(color = Color.White)) }
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.padding(end = 10.dp)) {
                    iconButtons.forEach { iconButton ->
                        val interactionSource = remember { MutableInteractionSource() }
                        val isTinted by isIconTinted(interactionSource)
                        IconButton(onClick = iconButton.second, interactionSource = interactionSource) {
                            Icon(
                                painter = painterResource(iconButton.first),
                                contentDescription = null, tint = Color.White.copy(if (isTinted) 0.5f else 1f)
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.fillMaxWidth().height(2.dp).background(color = Color.Black))
    }
}