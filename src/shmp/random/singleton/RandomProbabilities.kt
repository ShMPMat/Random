package shmp.random.singleton

import shmp.random.testProbability


fun Double.testProbability() = testProbability(this, RandomSingleton.random)
