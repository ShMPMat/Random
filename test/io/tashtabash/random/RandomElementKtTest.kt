package io.tashtabash.random

import io.tashtabash.random.singleton.RandomSingleton
import io.tashtabash.random.singleton.randomElementOrNull
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random


class RandomElementTest {
    @Test
    fun `randomElementOrNull() always returns null if all options have probability 0`() {
        RandomSingleton.safeRandom = Random(Random.nextInt())

        for (i in 0..1000)
            assertEquals(
                null,
                listOf(
                    1 withProbability 0.0,
                    2 withProbability 0.0,
                    3 withProbability 0.0
                ).randomElementOrNull()
            )
    }

    @Test
    fun `randomElementOrNull() always the only element with probability != 0`() {
        RandomSingleton.safeRandom = Random(Random.nextInt())

        for (i in 0..1000)
            assertEquals(
                3,
                listOf(
                    1 withProbability 0.0,
                    2 withProbability 0.0,
                    3 withProbability 0.00001
                ).randomElementOrNull()?.value
            )
    }
}
