package com.example.gomnakon4.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gomnakon4.R
import com.example.gomnakon4.ui.theme.GomNakon4Theme


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    GomNakon4Theme {

        Surface(color = Color.Gray, modifier = Modifier.fillMaxSize()) {
            CardThing()
        }
    }
}

@Composable
fun CardThing() {
    Box(modifier = Modifier.fillMaxSize()) {

        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)) {
            Row {
                Image(
                    modifier = Modifier
                        .padding(8.dp)
                        .height(60.dp)
                        .width(60.dp),
                    painter = painterResource(id = R.drawable.golden_key),
                    contentDescription = ""
                )
                Column() {
                    Row(modifier = Modifier.padding(4.dp)) {
                        Text(text = "name: ")
                        Text(text = "thing")
                    }
                    Row(modifier = Modifier.padding(4.dp)) {
                        Text(text = "where? ")
                        Text(text = "comod")
                    }
                }

            }
        }
    }
}