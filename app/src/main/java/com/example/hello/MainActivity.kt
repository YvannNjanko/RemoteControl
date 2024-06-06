package com.example.hello

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.hello.Model.Remotes
import com.example.hello.ui.theme.HelloTheme
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.BufferedReader
import java.io.InputStreamReader
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hello.Model.Remote

class ListMarquesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val jsonString = getJsonStringFromAssets("Irdb.Json")
            val remoteList = remember { Json.decodeFromString<Remotes>(jsonString) }
            val context = this
            val remoteListActivity = RemotesListActivity()
            val remoteActivity = RemoteActivity()

            HelloTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "RemoteListView") {
                    composable("RemoteListView") {
                        remoteListActivity.MyApp(navController, remoteList)
                    }
                    composable("remoteView/{remoteIndex}") { backStackEntry ->
                        val remoteIndexString = backStackEntry.arguments?.getString("remoteIndex")
                        val remoteIndex = remoteIndexString?.toIntOrNull() // Convertir la chaîne en Integer

                        if (remoteIndex != null) {
                            val remote = remoteList.remotes.getOrNull(remoteIndex)
                            if (remote != null) {
                                remoteActivity.MyButton(context, navController, remote)
                            } else {
                                // à faire
                            }
                        } else {
                            // à faire
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getJsonStringFromAssets(fileName: String): String {
    val inputStream = LocalContext.current.assets.open(fileName)
    return BufferedReader(InputStreamReader(inputStream)).use { it.readText() }
}

fun getPatternAndFrequencyForFunction(f : String, remote: Remote): Pair<List<Int>, Int>? {
    for (model in remote.models) {
        for (fonction in model.fonction) {
            if (fonction.nom == f) {
                return Pair(fonction.pattern, fonction.frequence)
            }
        }
    }
    return null // Si aucune fonction avec le nom f n'est trouvée
}




