package com.jescoding.simpleexpense.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed

@Composable
fun AddScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 18.dp)
    ) {

        val items = listOf("Foods", "Foods", "Foods")

        Text(
            text = "Total amount",
            fontWeight = FontWeight.SemiBold
        )

        TextField(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),
            value = "P0.00",
            onValueChange = {}
        )

        Text(
            modifier = Modifier
                .padding(top = 18.dp)
                .fillMaxWidth(),
            text = "Expense Category",
            fontWeight = FontWeight.SemiBold
        )


        DropdownMenu()


    }
}

@Composable
fun DropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Foods", "Transportation", "Allowance")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(top = 18.dp)
            .background(Color.Gray)
    ) {
        Text(
            items[selectedIndex],
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
                .clickable(onClick = { expanded = true })
                .background(
                    Color.Gray
                )
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp)
                .background(Color.White)
        ) {
            items.fastForEachIndexed { index, s ->
                DropdownMenuItem(
                    text = {
                        val disabledText = if (s == disabledValue) {
                            " (Disabled)"
                        } else {
                            ""
                        }
                        Text(
                            text = s + disabledText
                        )
                    },
                    onClick = {
                        selectedIndex = index
                        expanded = false
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    AddScreen()
}