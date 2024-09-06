package ui.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import memory.Registers
import ui.SecondaryBG

@Composable
fun RegisterSection() {
    val registers = Registers.registers
    Row(
        modifier = Modifier.fillMaxSize().padding(3.dp).clip(shape = RoundedCornerShape(5.dp))
            .background(color = SecondaryBG)
    ) {
        Column(modifier = Modifier.weight(1f).fillMaxHeight()) {
            registers.take(registers.size / 2).fastForEachIndexed { index, value ->
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text("x$index: $value")
                }
            }
        }
        Column(modifier = Modifier.weight(1f).fillMaxHeight()) {
            registers.take(registers.size / 2).fastForEachIndexed { index, value ->
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text("x${index + registers.size / 2}: $value")
                }
            }
        }
    }
}