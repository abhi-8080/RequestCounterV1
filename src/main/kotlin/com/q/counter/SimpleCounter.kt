package com.q.counter

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class SimpleCounter : IAtomicCounter {
    var counter: Int = 0

    @Synchronized
    override fun getNextVal(): Int = (++counter).also { logger.info("value = $it") }

    companion object{
        val logger: Logger = LoggerFactory.getLogger(SimpleCounter::class.java)
    }
}