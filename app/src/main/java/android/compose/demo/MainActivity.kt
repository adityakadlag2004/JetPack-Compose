package android.compose.demo

import android.compose.demo.ui.theme.Compose1Theme
import android.compose.demo.ui.theme.spacing
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose1Theme {
                var items by remember {
                    mutableStateOf((1..20).map {
                        ListItem(title = "Item $it", isSelected = false)
                    })
                }

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(items.size) { i ->
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                items = items.mapIndexed { j, item ->
                                    if (i == j) {
                                        item.copy(isSelected = !item.isSelected)
                                    } else item
                                }
                            }
                            .padding(MaterialTheme.spacing.medium),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "Item $i")
                            if (items[i].isSelected) {
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
    }






}



