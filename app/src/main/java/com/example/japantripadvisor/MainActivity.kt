package com.example.japantripadvisor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.japantripadvisor.ui.theme.JapanTripAdvisorTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JapanTripAdvisorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    TripDecision(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TripDecision(modifier: Modifier = Modifier) {
    Decisionmaker(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun Decisionmaker (modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf<String?>(null) }
    var clickCount by remember { mutableIntStateOf(0) }

    fun decide(probability: Double): String {
        return if (Random.nextDouble() < probability) "Yes" else "No"

    }
    Column(modifier = modifier.fillMaxSize()) {
    Row (

        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ){

            Text("Student ID: 1851219," +
                    " CCID: kmodi1 ")
        }
    }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Should we go?",
            fontSize = 24.sp,
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = result ?: "",
            fontSize = 24.sp,
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row {
            Button(onClick = {
                clickCount++
                result = decide(probability = 0.50)
            }) {
                Text(
                    text = "ok!",
                    fontSize = 20.sp,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                clickCount++
                result = decide(probability = 0.25)
            }) {
                Text(
                    text = "meh!",
                    fontSize = 20.sp,
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                clickCount++
                result = decide(probability = 0.10)
            }) {
                Text(
                    text = "nah!",
                    fontSize = 20.sp,
                )
            }
        }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Clicks: $clickCount",
                fontSize = 20.sp,
            )

        }
    }



@Preview(showBackground = true)
@Composable
fun TripDecisionPreview() {
JapanTripAdvisorTheme {
    TripDecision()
}}
