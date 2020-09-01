package shmp.random

import shmp.utils.Unwrappable


interface SampleSpaceObject {
    val probability: Double
}


interface UnwrappableSSO<E>: SampleSpaceObject, Unwrappable<E>


open class GenericSSO<E>(override val value: E, override val probability: Double): UnwrappableSSO<E>

fun <E> E.toSampleSpaceObject(probability: Double) = GenericSSO(this, probability)
