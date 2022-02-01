package android.compose.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var items by remember {
                mutableStateOf((1..20).map {
                    ListItem(title = "Item $it", isSelected = false)
                })
            }


        }
    }

    @Preview
    @Composable
    fun ComposablePreview() {
        val items by remember {
            mutableStateOf((1..20).map {
                ListItem(title = "Item $it", isSelected = false)
            })
        }
        DemoList(items = items)

    }

    @Composable
    fun DemoList(items: List<ListItem>) {
        var items2 = items
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items2.size) { i ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        items2 = items.mapIndexed { j, item ->
                            if (i == j) {
                                item.copy(isSelected = !item.isSelected)
                            } else item
                        }
                    }
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Item $i")
                    if (items2[i].isSelected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Yeah Nigga",
                            tint = Color.Green,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }


}



