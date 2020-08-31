package shmp.random

import kotlin.random.Random


fun <E> randomElementOrNull(list: List<E>, random: Random) =
    if (list.isNotEmpty()) list[random.nextInt(list.size)]
    else null

fun <E> randomElement(list: List<E>, random: Random) = list[random.nextInt(list.size)]


inline fun <E> randomElementOrNull(list: List<E>, mapper: (E) -> Double, random: Random): E? {
    val probabilities = list.map(mapper)
    var result = random.nextDouble() * probabilities.fold(0.0, Double::plus)

    for (i in probabilities.indices) {
        val probability = probabilities[i]

        if (result <= probability)
            return list[i]

        result -= probability
    }

    return null
}

inline fun <E> randomElement(list: List<E>, mapper: (E) -> Double, random: Random) =
    randomElementOrNull(list, mapper, random)
        ?: throw RandomException("Can't choose an element from an empty collection")


inline fun <E> randomElementOrNull(iterable: Iterable<E>, mapper: (E) -> Double, random: Random): E? {
    val probabilities = iterable.map(mapper)
    var result = random.nextDouble() * probabilities.fold(0.0, Double::plus)

    for ((i, element) in iterable.withIndex()) {
        val probability = probabilities[i]

        if (result <= probability)
            return element

        result -= probability
    }

    return null
}

inline fun <E> randomElement(iterable: Iterable<E>, mapper: (E) -> Double, random: Random) =
    randomElementOrNull(iterable, mapper, random)
        ?: throw RandomException("Can't choose an element from an empty collection")


inline fun <E> randomElementOrNull(array: Array<E>, mapper: (E) -> Double, random: Random): E? {
    val probabilities = array.map(mapper)
    var result = random.nextDouble() * probabilities.fold(0.0, Double::plus)

    for (i in probabilities.indices) {
        val probability = probabilities[i]

        if (result <= probability)
            return array[i]

        result -= probability
    }

    return null
}

inline fun <E> randomElement(array: Array<E>, mapper: (E) -> Double, random: Random) =
    randomElementOrNull(array, mapper, random)
        ?: throw RandomException("Can't choose an element from an empty collection")


fun <E : SampleSpaceObject> randomElementOrNull(array: Array<E>, random: Random): E? =
    randomElementOrNull(array, { it.probability }, random)

fun <E : SampleSpaceObject> randomElement(array: Array<E>, random: Random): E =
    randomElement(array, { it.probability }, random)


fun <E : SampleSpaceObject> randomElementOrNull(list: List<E>, random: Random): E? =
    randomElementOrNull(list, { it.probability }, random)

fun <E : SampleSpaceObject> randomElement(list: List<E>, random: Random): E =
    randomElement(list, { it.probability }, random)


fun <T, E : GenericSSO<T>> randomUnwrappedElementOrNull(array: Array<E>, random: Random): T? =
    randomElementOrNull(array, { it.probability }, random)?.item

fun <T, E : GenericSSO<T>> randomUnwrappedElement(array: Array<E>, random: Random): T =
    randomElement(array, { it.probability }, random).item


fun <T, E : GenericSSO<T>> randomUnwrappedElementOrNull(list: List<E>, random: Random): T? =
    randomElementOrNull(list, { it.probability }, random)?.item

fun <T, E : GenericSSO<T>> randomUnwrappedElement(list: List<E>, random: Random): T =
    randomElement(list, { it.probability }, random).item
