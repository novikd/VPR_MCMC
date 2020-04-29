package ru.ifmo.ctd.novik.phylogeny.utils

import kotlin.math.exp
import kotlin.math.ln
import kotlin.random.Random

var GlobalRandom = Random(0)

class LnPoissonProbabilityMassFunction(private val lambda: Double) {
    operator fun invoke(k: Int): Double = -lambda + k * ln(lambda) +
            generateSequence(1) { it + 1 }
                    .take(k)
                    .map { -ln(it.toDouble()) }.sum()
}

class PoissonRandomVariable(val lambda: Double, val random: Random = GlobalRandom) {
    fun next(): Int {
        var k = 0
        var p = 1.0
        val L = exp(-lambda)
        do {
            ++k
            p *= random.nextDouble()
        } while (p > L)
        return k - 1
    }
}
