package com.q.counter

class SimpleCounter : IAtomicCounter {
    var counter: Int = 0

    @Synchronized
    override fun getNextVal(): Int = (++counter).also { println("value = $it") }
}