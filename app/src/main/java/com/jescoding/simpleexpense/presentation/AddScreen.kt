package com.jescoding.simpleexpense.presentation

import android.widget.EditText
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 18.dp)
    ) {
        Text(
            text = "Total amount",
            fontWeight = FontWeight.SemiBold
        )

        TextField(
            modifier = Modifier.padding(top = 12.dp),
            value = "P0.00",
            onValueChange = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AddScreenPreview() {
    AddScreen()
}