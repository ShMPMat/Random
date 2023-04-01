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
    max: Int = list.map(mapper).count { it > 0.0 }
): List<E> {
    if (list.isEmpty())
        throw RandomException("Can't choose an element from an empty collection")
    val resultList = ArrayList<E>()
    val size = random.nextInt(min, max)
    val probabilities = list.map(mapper).toMutableList()
    val probabilitySum = probabilities.fold(0.0, Double::plus)
    var sum = random.nextDouble() * probabilitySum

    for (i in 1..size) {
        var currentSum = sum
        for (j in probabilities.indices) {
            val probability = probabilities[j]
            if (currentSum <= probability) {
                resultList.add(list[j])
                sum -= probabilities[j]
                probabilities[j] = 0.0
                break
            }
            currentSum -= probability
        }
    }
    return resultList
}
