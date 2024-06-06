package com.example.hello

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Close
import androidx.compose.material.icons.sharp.KeyboardArrowDown
import androidx.compose.material.icons.sharp.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.hello.Model.Remote

class RemoteActivity {
    @Composable
    fun MyButton(context: Context, navController: NavHostController, remote: Remote) {
        var consumerIr = ConsumerIr()
        Surface(
            color = Color.DarkGray,
            modifier = Modifier
                .fillMaxSize()
        ){
            Row(
                Modifier.padding(top = 15.dp),
            ) {
                IconButton(
                    onClick = {
                        navController.popBackStack() // Retourne à l'écran précédent (RemoteListView)
                    },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Sharp.Close,
                        contentDescription = "Volume -",
                        tint = Color.White
                    )
                }
            }
            Column {
                Column(
                    Modifier.padding(start = 85.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 100.dp),
                        text = remote.marque,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        text = remote.type,
                        color = Color.Gray,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(
                    onClick = {
                        val buttonFunction = getPatternAndFrequencyForFunction("Power", remote)
                        if (buttonFunction != null) {
                            val (pattern, frequency) = buttonFunction
                            consumerIr.sendIRCommand(context, frequency, pattern)
                        } else {
                            // à gerer
                        }
                    },
                    modifier = Modifier.size(150.dp),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    contentPadding = PaddingValues(bottom = 50.dp),
                    shape = CircleShape
                ) {
                    Text(
                        text = "💡",
                        color = Color.White,
                        fontSize = 60.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(bottom = 40.dp, top = 20.dp)
                ) {
                    IconButton(
                        onClick = {
                            val buttonFunction = getPatternAndFrequencyForFunction("Volume -", remote)
                            if (buttonFunction != null) {
                                val (pattern, frequency) = buttonFunction
                                consumerIr.sendIRCommand(context, frequency, pattern)
                            } else {
                                // à gerer
                            }
                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Sharp.KeyboardArrowDown,
                            contentDescription = "Volume -",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(0.dp))
                    Text(
                        text = "🔈Volume 🔉",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(0.dp))
                    IconButton(
                        onClick = {
                            val buttonFunction = getPatternAndFrequencyForFunction("Volume +", remote)
                            if (buttonFunction != null) {
                                val (pattern, frequency) = buttonFunction
                                consumerIr.sendIRCommand(context, frequency, pattern)
                            } else {
                                // à gerer
                            }
                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Sharp.KeyboardArrowUp,
                            contentDescription = "Volume+",
                            tint = Color.White
                        )
                    }
                }

                Row(
                ) {
                    IconButton(
                        onClick = {
                            val buttonFunction = getPatternAndFrequencyForFunction("Chaine -", remote)
                            if (buttonFunction != null) {
                                val (pattern, frequency) = buttonFunction
                                consumerIr.sendIRCommand(context, frequency, pattern)
                            } else {
                                // à gerer
                            }
                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Sharp.KeyboardArrowDown,
                            contentDescription = "chaine -",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(0.dp))
                    Text(
                        text = "📺 Channel 📺",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(0.dp))
                    IconButton(
                        onClick = {
                            val buttonFunction = getPatternAndFrequencyForFunction("Chaine +", remote)
                            if (buttonFunction != null) {
                                val (pattern, frequency) = buttonFunction
                                consumerIr.sendIRCommand(context, frequency, pattern)
                            } else {
                                // à gerer
                            }
                        },
                        modifier = Modifier.size(48.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Sharp.KeyboardArrowUp,
                            contentDescription = "chaine +",
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}