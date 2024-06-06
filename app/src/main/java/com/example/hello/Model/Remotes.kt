package com.example.hello.Model

import kotlinx.serialization.Serializable

@Serializable
data class Fonction(
    val nom: String,
    val pattern: List<Int>,
    val frequence: Int
)

@Serializable
data class Model(
    val nom: String,
    val fonction: List<Fonction>
)

@Serializable
data class Remote(
    val marque: String,
    val type: String,
    val models: List<Model>
)

@Serializable
data class Remotes(
    val remotes: List<Remote>
)
