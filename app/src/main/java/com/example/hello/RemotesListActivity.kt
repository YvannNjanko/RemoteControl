package com.example.hello

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.KeyboardArrowRight
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.hello.Model.Remotes

class RemotesListActivity {
    @Composable
    fun MyApp(navController: NavHostController, remoteList: Remotes) {
        Surface(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column {
                Text(
                    modifier = Modifier
                        .padding(vertical = 60.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "Choose your Device",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize * 1.5f
                    )
                )

                remoteList.remotes.forEach { remote ->
                    Row(modifier = Modifier.padding(24.dp)) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                modifier = Modifier
                                    .padding(bottom = 10.dp, start = 20.dp),
                                text = remote.type,
                                color = Color.White,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = MaterialTheme.typography.bodyLarge.fontSize * 1.5f
                                )
                            )
                            Text(
                                modifier = Modifier
                                    .padding(bottom = 10.dp, start = 20.dp),
                                text = remote.marque,
                                color = Color.Black,
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Medium,
                                    fontSize = MaterialTheme.typography.bodyLarge.fontSize * 1.1f
                                )
                            )
                        }
                        ElevatedButton(
                            modifier = Modifier.width(120.dp),
                            onClick = {
                                val remoteIndex = remoteList.remotes.indexOf(remote)
                                navController.navigate("remoteView/$remoteIndex")
                            }
                        ) {
                            Text("Connect")
                            Icon(Icons.Sharp.KeyboardArrowRight, contentDescription = "Connect")
                        }
                    }
                }
            }
        }
    }
}