package io.tashtabash.random

import io.tashtabash.utils.Unwrappable


interface SampleSpaceObject {
    val probability: Double
}


abstract class UnwrappableSSO<E>(override val value: E): SampleSpaceObject, Unwrappable<E>

open class GenericSSO<E>(value: E, override val probability: Double): UnwrappableSSO<E>(value)

fun <E> E.toSampleSpaceObject(probability: Double) = GenericSSO(this, probability)
