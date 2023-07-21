package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskManager(getString(R.string.status), getString(R.string.remarks))
                }
            }
        }
    }
}

@Composable
fun TaskManager(comment: String, remarks: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.ic_task_completed)

    Column(
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "$comment!",
            modifier = modifier.padding(
                top = 24.dp,
                bottom = 8.dp
            ).align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = remarks,
            modifier = modifier.align(Alignment.CenterHorizontally),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskManager(stringResource(id = R.string.status), stringResource(id = R.string.remarks))
    }
}