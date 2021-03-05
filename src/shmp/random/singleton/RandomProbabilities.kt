package shmp.random.singleton

import shmp.random.singleton.Success.*
import shmp.random.testProbability


fun Double.testProbability() = testProbability(this, RandomSingleton.random)

inline fun Double.chanceOf(block: () -> Unit): Success {
    return if (this.testProbability()) {
        block()
        SUCCESS
    } else FAILURE
}

inline fun Double.chanceOfNot(block: () -> Unit): Success {
    if (!this.testProbability()) {
        block()
        return SUCCESS
    }
    return FAILURE
}

inline infix fun Success.otherwise(block: () -> Unit) {
    if (!isSuccess)
        block()
}

inline fun <E> Double.chanceOf(block: () -> E): E? {
    return if (this.testProbability()) {
        block()
    } else null
}

enum class Success(val isSuccess: Boolean) {
    SUCCESS(true),
    FAILURE(false)
}
