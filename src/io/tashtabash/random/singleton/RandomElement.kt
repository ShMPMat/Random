package io.tashtabash.random.singleton

import io.tashtabash.random.SampleSpaceObject
import io.tashtabash.random.UnwrappableSSO


fun <E> List<E>.randomElementOrNull() = io.tashtabash.random.randomElementOrNull(this, RandomSingleton.random)

fun <E> List<E>.randomElement() = io.tashtabash.random.randomElement(this, RandomSingleton.random)


inline fun <E> List<E>.randomElementOrNull(mapper: (E) -> Double): E? =
    io.tashtabash.random.randomElementOrNull(this, mapper, RandomSingleton.random)

inline fun <E> List<E>.randomElement(mapper: (E) -> Double) =
    io.tashtabash.random.randomElement(this, mapper, RandomSingleton.random)


inline fun <E> Array<E>.randomElementOrNull(mapper: (E) -> Double): E? =
    io.tashtabash.random.randomElementOrNull(this, mapper, RandomSingleton.random)

inline fun <E> Array<E>.randomElement(mapper: (E) -> Double) =
    io.tashtabash.random.randomElement(this, mapper, RandomSingleton.random)


fun <E : SampleSpaceObject> Array<E>.randomElementOrNull(): E? =
    io.tashtabash.random.randomElementOrNull(this, RandomSingleton.random)

fun <E : SampleSpaceObject> Array<E>.randomElement(): E =
    io.tashtabash.random.randomElement(this, RandomSingleton.random)


fun <E : SampleSpaceObject> List<E>.randomElementOrNull(): E? =
    io.tashtabash.random.randomElementOrNull(this, RandomSingleton.random)

fun <E : SampleSpaceObject> List<E>.randomElement(): E =
    io.tashtabash.random.randomElement(this, RandomSingleton.random)


    fun <T, E : UnwrappableSSO<out T>> Array<E>.randomUnwrappedElementOrNull(): T? =
    io.tashtabash.random.randomUnwrappedElementOrNull(this, RandomSingleton.random)

fun <T, E : UnwrappableSSO<out T>> Array<E>.randomUnwrappedElement(): T =
    io.tashtabash.random.randomUnwrappedElement(this, RandomSingleton.random)


fun <T, E : UnwrappableSSO<out T>> List<E>.randomUnwrappedElementOrNull(): T? =
    io.tashtabash.random.randomUnwrappedElementOrNull(this, RandomSingleton.random)

fun <T, E : UnwrappableSSO<out T>> List<E>.randomUnwrappedElement(): T =
    io.tashtabash.random.randomUnwrappedElement(this, RandomSingleton.random)
