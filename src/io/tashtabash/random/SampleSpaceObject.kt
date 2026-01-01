package io.tashtabash.random

import io.tashtabash.utils.Unwrappable


interface SampleSpaceObject {
    val probability: Double
}


abstract class UnwrappableSSO<E>(override val value: E): SampleSpaceObject, Unwrappable<E>

data class GenericSSO<E>(override val value: E, override val probability: Double): UnwrappableSSO<E>(value)

fun <E> E.toSampleSpaceObject(prob: Double) = GenericSSO(this, prob)

infix fun <E> E.withProb(prob: Double): GenericSSO<E> =
    GenericSSO(this, prob)

infix fun <E> List<E>.allWithProb(prob: Double): List<GenericSSO<E>> =
    map { it withProb prob }

infix fun <E> List<E>.allWithProb(mapper: (E) -> Double): List<GenericSSO<E>> =
    map { it withProb mapper(it) }

infix fun <E> List<E>.allWithProb(mapper: (Int, E) -> Double): List<GenericSSO<E>> =
    mapIndexed { i, e -> e withProb mapper(i, e) }
