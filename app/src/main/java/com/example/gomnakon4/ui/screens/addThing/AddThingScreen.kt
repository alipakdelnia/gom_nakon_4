package com.example.gomnakon4.ui.screens.addThing


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.gomnakon4.data.database.AppDatabase
import com.example.gomnakon4.data.model.Thing
import com.example.gomnakon4.ui.theme.GomNakon4Theme
import com.example.gomnakon4.utils.TextOfMe
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dev.burnoo.cokoin.navigation.getNavController
import dev.burnoo.cokoin.navigation.getNavViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    GomNakon4Theme {

        Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
            AddThingScreen()
        }
    }
}

@Composable
fun AddThingScreen(database: AppDatabase? = null) {
val uiController = rememberSystemUiController()

val context = LocalContext.current
val navigation = getNavController()
val viewModel = getNavViewModel<AddThingViewModel>()

    val thingName = remember { mutableStateOf("") }
    val category = remember { mutableStateOf("") }
    val whereIsIt = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp, top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            TextOfMe(text = "Add new thing", padding = 16, textSize = 24)
            OutlineTextInput(label = "Thing name") { input ->
                thingName.value = input
            }
            Spacer(modifier = Modifier.padding(8.dp))
            OutlineTextInput(label = "Category") { input ->
                category.value = input
            }
            Spacer(modifier = Modifier.padding(8.dp))
            OutlineTextInput(label = "Where is it?") { input ->
                whereIsIt.value = input
            }

            Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.Bottom) {
                Button(modifier = Modifier.padding(12.dp),
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    onClick = {
                        if (thingName.value.isNotBlank() && category.value.isNotBlank() && whereIsIt.value.isNotBlank()) {
                                saveThingsToDatabase(database!!, thingName.value, category.value, whereIsIt.value)

                        } else {
//                            Toast.makeText(this, "he", Toast.LENGTH_SHORT).show()
                        }
                    }) {
                    Text(text = "save")
                }
                Button(modifier = Modifier.padding(12.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    onClick = { }) {
                    Text(text = "cancel")
                }
            }
        }


    }

}

private fun saveThingsToDatabase(
    database: AppDatabase,
    thingName: String,
    category: String,
    whereIsIt: String
) {
        database.thingDao().insert(Thing(name = thingName, category = category, locate = whereIsIt))

}

@Composable
fun OutlineTextInput(label: String, onInputSubmitted: (String) -> Unit) {
    val inputText = remember { mutableStateOf("") }

    OutlinedTextField(
        value = inputText.value,
        onValueChange = { inputText.value = it },
        label = { Text(label) },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onInputSubmitted(inputText.value)
            }
        )
}

