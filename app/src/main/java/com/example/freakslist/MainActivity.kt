package com.example.freakslist

import FreakItem
import FreaksList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.freakslist.ui.theme.FreaksListTheme
import androidx.compose.ui.graphics.Color


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreaksListTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FreaksList()
                }
            }
        }
    }
}


@Preview
@Composable
fun FreakItemPreview() {
    Box(modifier = Modifier.background(Color.Yellow)) {
        FreakItem("Calin",R.drawable.calin)
    }
}