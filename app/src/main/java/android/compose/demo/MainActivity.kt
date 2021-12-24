package android.compose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val modifier =
                Modifier
                    .padding(10.dp)
                    .background(Color.Green)
                    .fillMaxWidth(1f)
                    .fillMaxHeight(0.5f)
            Column(modifier=modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Greeting(name = "Hello")
                Greeting(name = "Aditya")
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = name)
    }


}


