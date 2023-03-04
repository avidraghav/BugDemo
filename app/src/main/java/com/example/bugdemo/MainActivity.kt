package com.example.bugdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.bugdemo.ui.theme.BugDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BugDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DemoLayout()
                }
            }
        }
    }
}

@Composable
fun DemoLayout() {
    var guess by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.image_composable)
                )

                /*
                 * Image recomposes whenever OutlinedTextField recomposes which should
                 * not be the case as OutlinedTextField and Image are don't share state.
                 */
                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(id = R.string.box_composable)
                )
                /*
                 * Box doesn't recomposes whenever OutlinedTextField recomposes as they don't
                 * share state. This is the expected behaviour.
                 */
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .paint(
                            painterResource(id = R.drawable.ic_launcher_background)
                        )
                )
            }
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = guess,
            onValueChange = { guess = it },
            label = {
                Text(text = stringResource(R.string.enter_any_text))
            }
        )
    }
}
