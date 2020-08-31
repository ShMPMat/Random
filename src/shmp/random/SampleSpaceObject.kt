package shmp.random

interface SampleSpaceObject {
    val probability: Double
}

class GenericSSO<E>(val item: E, override val probability: Double): SampleSpaceObject

fun <E> E.toSampleSpaceObject(probability: Double) = GenericSSO(this, probability)
