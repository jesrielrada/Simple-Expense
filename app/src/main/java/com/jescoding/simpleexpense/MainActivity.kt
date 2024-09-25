package com.jescoding.simpleexpense

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jescoding.simpleexpense.presentation.AddScreen
import com.jescoding.simpleexpense.presentation.theme.SimpleExpenseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleExpenseTheme {
                AddScreen()
            }
        }
    }
}

