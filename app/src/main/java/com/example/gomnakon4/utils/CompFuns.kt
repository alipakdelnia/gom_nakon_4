package com.example.gomnakon4.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//------------ text -------------
@Composable
fun TextOfMe(text: String, padding: Int, textSize: Int) {
    Text(
        modifier = Modifier.padding(padding.dp),
        text = text,
        fontSize = textSize.sp
    )
}