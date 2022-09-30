package com.q.counter

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.stream.IntStream

internal class SimpleCounterTest {

    lateinit var counter: SimpleCounter

    @BeforeEach
    fun setUp() {
        counter = SimpleCounter()
    }

    @Test
    fun `get next val should return the next increment`() {
        IntStream.range(1, 10).forEach { expected ->
            Assertions.assertThat(counter.getNextVal()).isEqualTo(expected)
        }
    }
}