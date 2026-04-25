package io.tashtabash.random

import kotlin.random.Random


fun <E> randomSublist(list: List<E>, random: Random, min: Int = 0, max: Int = list.size) =
    list.shuffled(random).subList(0, random.nextInt(min, max))

fun <E> randomSublist(
    array: Array<E>,
    mapper: (E) -> Double,
    random: Random,
    min: Int = 0,
    max: Int = array.map(mapper).count { it > 0.0 }
): List<E> =
    randomSublist(array.toList(), mapper, random, min, max)

fun <E> randomSublist(
    list: List<E>,
    mapper: (E) -> Double,
    random: Random,
    min: Int = 0,
    max: Int = list.map(mapper).count { it > 0.0 } + 1
): List<E> {
    if (list.isEmpty())
        throw RandomException("Can't choose an element from an empty collection")

    val resultList = mutableListOf<E>()
    val resultSize = random.nextInt(min, max)

    val probabilities = list.map(mapper).toMutableList()
    var probabilitySum = probabilities.sum()

    for (i in 1..resultSize) {
        var draw = random.nextDouble() * probabilitySum
        for (j in probabilities.indices) {
            val probability = probabilities[j]
            if (draw <= probability) {
                resultList.add(list[j])
                probabilitySum -= probabilities[j]
                probabilities[j] = .0
                break
            }
            draw -= probability
        }
    }
    return resultList
}
