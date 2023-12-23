package com.example.gomnakon4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.gomnakon4.ui.screens.addThing.AddThingScreen
import com.example.gomnakon4.ui.theme.GomNakon4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GomNakon4Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AddThingScreen()
                }
            }
        }
    }


}

@Composable
private fun MainScreen() {
    val showDialogAddItem = remember { mutableStateOf(false) }
    val nameOfThing = remember { mutableStateOf("") }
    val locateOfThing = remember { mutableStateOf("") }
    val cardList = remember { mutableStateOf(mutableListOf<String>()) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (nameOfThing.value.isNotEmpty() && locateOfThing.value.isNotEmpty()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Card(modifier = Modifier.padding(16.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Name: ${nameOfThing.value}")
                        Text(text = "Location: ${locateOfThing.value}")
                    }
                }
            }
        }

        Button(onClick = { showDialogAddItem.value = true }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_add_24),
                contentDescription = "Add",
                modifier = Modifier.padding(end = 8.dp)
            )
            Text("Open Dialog")
        }

        if (showDialogAddItem.value) {
            Dialog(
                onDismissRequest = { showDialogAddItem.value = false }
            ) {
                AlertDialog(
                    onDismissRequest = {},
                    title = { Text(text = "Dialog Title") },
                    text = {
                        Column {
                            TextField(
                                value = nameOfThing.value,
                                onValueChange = { value ->
                                    nameOfThing.value = value
                                },
                                label = { Text("Enter things name") }
                            )
                            TextField(
                                value = locateOfThing.value,
                                onValueChange = { value ->
                                    locateOfThing.value = value
                                },
                                label = { Text("Enter things location") }
                            )
                        }
                    },
                    confirmButton = {
                        Button(onClick = {
                            showDialogAddItem.value = false }) {
                            Text("OK")
                        }
                    },
                    dismissButton = {
                        Button(onClick = { showDialogAddItem.value = false }) {
                            Text("Cancel")
                        }
                    }
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GomNakon4Theme {
        Surface(color = Color.Gray, modifier = Modifier.fillMaxSize()) {
            MainScreen()
        }

    }
}