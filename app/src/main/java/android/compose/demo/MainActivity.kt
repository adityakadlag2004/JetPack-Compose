package android.compose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


        }
    }


    @Composable
    fun ListViewWithToolbarAndLazyColumn() {
        Column(Modifier.fillMaxSize()) {
            TopAppBar(modifier = Modifier.fillMaxWidth()) {
                Text(text = "ToolBar Main", fontSize = 19.sp)
            }
            LazyColumn() {
                items(1000) {
                    Text(
                        text = "Yeah Item $it",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp)
                    )
                }

            }
        }
    }

    @Composable
    fun EdittextWithButton() {
        val scope = rememberCoroutineScope()
        var textFieldState by remember {
            mutableStateOf("")
        }
        val state = rememberScaffoldState()
        Scaffold(
            Modifier.fillMaxSize(),
            scaffoldState = state
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
            ) {

                TextField(
                    value = textFieldState,
                    label = {
                        Text(text = "Enter Your Name")
                    },
                    onValueChange = {
                        textFieldState = it
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        scope.launch {
                            state.snackbarHostState.showSnackbar("Hello $textFieldState")
                        }
                    }, modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(10.dp)
                ) {
                    Text(text = "Press")
                }
            }
        }
    }


}


