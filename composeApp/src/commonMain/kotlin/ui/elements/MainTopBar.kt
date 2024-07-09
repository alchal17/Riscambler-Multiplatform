package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
fun MainTopBar(topBarOptions: List<TopAppBarButton>, iconButtons: List<Pair<DrawableResource, () -> Unit>>) {
    Column {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.keys),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.padding(horizontal = 3.dp)
                    )

                    //Draws Buttons
                    topBarOptions.forEach { topBarOption ->
                        var visible by remember { mutableStateOf(false) }
                        Button(
                            onClick = { visible = !visible },
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(
                                SecondaryBG
                            ),
                        ) {
                            Text(
                                topBarOption.buttonText,
                                style = TextStyle(color = Color.White)
                            )
                            DropdownMenu(
                                expanded = visible,
                                onDismissRequest = { visible = false },
                                modifier = Modifier.background(color = SecondaryBG)
                            ) {
                                //Draws menu with options for each button
                                topBarOption.suboptions.forEachIndexed { index, subOption ->
                                    DropdownMenuItem(
                                        onClick = {
                                            visible = false
                                            subOption.second()
                                        },
                                        modifier = Modifier.height(50.dp)
                                    ) { Text(subOption.first, style = TextStyle(color = Color.White)) }
                                    if (index + 1 < topBarOption.suboptions.size) {
                                        Spacer(
                                            modifier = Modifier.fillMaxWidth().height(2.dp)
                                                .background(color = Color.Black)
                                        )
                                    }
                                }
                            }
                        }
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