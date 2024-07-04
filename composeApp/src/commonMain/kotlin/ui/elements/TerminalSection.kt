package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import riscambler_mutliplatform.composeapp.generated.resources.Res
import riscambler_mutliplatform.composeapp.generated.resources.terminal
import ui.SecondaryBG
import ui.textFieldStyles.getMainTextFieldColors

@Composable
fun TerminalSection(terminalValue: String, onTerminalValueInput: (newValue: String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.fillMaxWidth().height(2.dp).background(color = Color.Black))
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Box(
                modifier = Modifier.fillMaxSize().padding(15.dp).clip(RoundedCornerShape(8.dp))
                    .background(color = SecondaryBG)
                    .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(8.dp))
            ) {
                TextField(
                    value = terminalValue,
                    onValueChange = onTerminalValueInput,
                    modifier = Modifier.fillMaxSize(),
                    colors = getMainTextFieldColors(),
                    leadingIcon = {
                        Box(modifier = Modifier.fillMaxHeight()) {
                            Icon(
                                painter = painterResource(Res.drawable.terminal),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.padding(top = 10.dp, start = 5.dp)
                            )
                        }
                    }
                )
            }
        }
    }
}