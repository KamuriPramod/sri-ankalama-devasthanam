package com.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ui.HomeScreen
import com.example.ui.theme.SriAnkalamaDevasthanamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SriAnkalamaDevasthanamTheme {
                HomeScreen(
                    onBookSevaClicked = { seva ->
                        Toast.makeText(this, "Selected: ${seva.title}", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}
