package io.tashtabash.random.singleton

import kotlin.random.Random


object RandomSingleton {
    var safeRandom: Random? = null

    val random: Random
        get() = safeRandom ?: throw RandomUninitializedException
}
