package io.tashtabash.random

import kotlin.random.Random


fun testProbability(probability: Double, random: Random) = random.nextDouble() <= probability
