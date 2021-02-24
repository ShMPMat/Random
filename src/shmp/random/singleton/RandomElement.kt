package shmp.random.singleton

import shmp.random.*


fun <E> List<E>.randomElementOrNull() = randomElementOrNull(this, RandomSingleton.random)

fun <E> List<E>.randomElement() = randomElement(this, RandomSingleton.random)


inline fun <E> List<E>.randomElementOrNull(mapper: (E) -> Double): E? =
    randomElementOrNull(this, mapper, RandomSingleton.random)

inline fun <E> List<E>.randomElement(mapper: (E) -> Double) =
    randomElement(this, mapper, RandomSingleton.random)


inline fun <E> Array<E>.randomElementOrNull(mapper: (E) -> Double): E? =
    randomElementOrNull(this, mapper, RandomSingleton.random)

inline fun <E> Array<E>.randomElement(mapper: (E) -> Double) =
    randomElement(this, mapper, RandomSingleton.random)


fun <E : SampleSpaceObject> Array<E>.randomElementOrNull(): E? = randomElementOrNull(this, RandomSingleton.random)

fun <E : SampleSpaceObject> Array<E>.randomElement(): E = randomElement(this, RandomSingleton.random)


fun <E : SampleSpaceObject> List<E>.randomElementOrNull(): E? = randomElementOrNull(this, RandomSingleton.random)

fun <E : SampleSpaceObject> List<E>.randomElement(): E = randomElement(this, RandomSingleton.random)


fun <T, E : UnwrappableSSO<T>> Array<E>.randomUnwrappedElementOrNull(): T? =
    randomUnwrappedElementOrNull(this, RandomSingleton.random)

fun <T, E : UnwrappableSSO<T>> Array<E>.randomUnwrappedElement(): T =
    randomUnwrappedElement(this, RandomSingleton.random)


fun <T, E : UnwrappableSSO<T>> List<E>.randomUnwrappedElementOrNull(): T? =
    randomUnwrappedElementOrNull(this, RandomSingleton.random)

fun <T, E : UnwrappableSSO<T>> List<E>.randomUnwrappedElement(): T =
    randomUnwrappedElement(this, RandomSingleton.random)
