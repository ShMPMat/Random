package io.tashtabash.random

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.random.Random


class RandomSublistTest {
    @Test
    fun `randomSublist() selects unique elements`() {
        val samples = listOf(
            580.0,
            3.0,
            2.0,
            1.0,
        )

        for (i in 0..1000)
            assertEquals(
                4,
                randomSublist(samples, { it }, Random(Random.nextInt()), 4)
                    .distinct()
                    .size,
            )
    }
}
