package shmp.random.singleton

import shmp.random.testProbability


fun Double.testProbability() = testProbability(this, RandomSingleton.random)

inline fun Double.chanceOf(block: () -> Unit) {
    if (this.testProbability())
        block()
}
