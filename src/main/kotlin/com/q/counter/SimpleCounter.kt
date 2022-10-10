package com.q.counter

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantReadWriteLock

class SimpleCounter : IAtomicCounter {
    private var lock = ReentrantReadWriteLock()
    private val writeLock: ReentrantReadWriteLock.WriteLock = lock.writeLock()
    private var counter: Int = 0

    override fun getNextVal() =
        try {
            writeLock.lock()
            (++counter).also { logger.info("value = $it") }
        } finally {
            writeLock.unlock()
        }


    companion object {
        val logger: Logger = LoggerFactory.getLogger(SimpleCounter::class.java)
    }
}