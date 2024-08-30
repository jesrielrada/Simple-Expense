package com.jescoding.simpleexpense.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.wrapContentSize()) {

        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
                .padding(
                    top = 18.dp,
                )
        ) {
            Text(
                modifier = Modifier.padding(start = 18.dp),
                text = "Hi",
                color = Color.Black,
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Black
            )

            SubHeader()

            ExpenseList()
        }

        FloatingActionButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(18.dp),
            containerColor = Color.Gray,
            shape = CircleShape,
            onClick = { /*TODO*/ }
        ) {

            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = null,
                tint = Color.White
            )

        }
    }

}

@Composable
fun ExpenseList() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 18.dp)
            .background(Color.White)
    )
}

@Composable
fun SubHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 22.dp, start = 18.dp, end = 18.dp)
            .height(68.dp)
            .border(BorderStroke(1.dp, Color.Black)),
    ) {
        Column(
            modifier = Modifier
                .padding(14.dp)
        ) {
            Text(
                fontSize = 16.sp,
                text = "Total Expenses",
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                text = "P 123,456.78"
            )
        }
    }
}

@Composable
fun ExpenseCard() {
    Column {

    }
}

@Composable
@Preview(showBackground = true)
fun ExpenseCardPreview() {
    ExpenseCard()
}

@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview() {
    DashboardScreen()
}

@Composable
@Preview(showBackground = true)
fun SubHeaderPreview() {
    SubHeader()
}