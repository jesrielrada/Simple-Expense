package com.jescoding.simpleexpense.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jescoding.simpleexpense.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 16.sp,
                        color = Color.Black,
                        text = "Submit Expense",
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = null
                        )
                    }
                }
            )
        },
        content = {
            Box(
                modifier = Modifier.padding(it)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 18.dp)
                ) {

                    Text(
                        text = "Total amount",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace
                    )

                    TextField(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        value = "P0.00",
                        onValueChange = {}
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 18.dp)
                            .fillMaxWidth(),
                        text = "Expense Category",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace
                    )


                    DropdownMenu()

                    Text(
                        modifier = Modifier
                            .padding(top = 18.dp)
                            .fillMaxWidth(),
                        text = "Transaction Date",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace
                    )

                    TransactionDate()

                    Text(
                        modifier = Modifier
                            .padding(top = 18.dp)
                            .fillMaxWidth(),
                        text = "Description",
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.Monospace
                    )

                    DescriptionField()

                }

                ConfirmButton(
                    modifier = Modifier
                        .padding(bottom = 16.dp, start = 8.dp, end = 8.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                )
            }
        })


}

@Composable
fun ConfirmButton(modifier: Modifier) {

    Button(
        modifier = modifier,
        onClick = {

        }
    ) {
        Text(text = "Add Expense")
    }
}

@Composable
fun DescriptionField() {

    Box(modifier = Modifier.wrapContentSize()) {
        TextField(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .height(200.dp),
            value = "Add Description",
            onValueChange = {}
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionDate() {

    var showDialog by remember { mutableStateOf(false) }
    val dateState = rememberDatePickerState()

    Box(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(38.dp)
            .background(Color.LightGray)
    ) {

        Text(
            text = "Select Date",
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
                .clickable(onClick = {
                    showDialog = true
                })

        )

        Image(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .height(60.dp)
                .padding(end = 8.dp),
            painter = (painterResource(id = R.drawable.baseline_date_range_24)),
            contentDescription = null
        )

        if (showDialog) {
            DatePickerDialog(
                onDismissRequest = {
                    showDialog = false
                },
                dismissButton = {

                },
                confirmButton = {

                }
            ) {
                DatePicker(
                    state = dateState,
                    showModeToggle = true
                )
            }
        }

    }
}

@Composable
fun DropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Foods", "Transportation", "Allowance")
    var selectedIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .height(36.dp)
            .background(Color.LightGray)
    ) {

        Text(
            text = items[selectedIndex],
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 8.dp)
                .clickable(onClick = { expanded = true })

        )

        Image(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .height(60.dp)
                .padding(end = 8.dp),
            painter = (painterResource(id = R.drawable.baseline_arrow_drop_down_24)),
            contentDescription = null
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp)
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item
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