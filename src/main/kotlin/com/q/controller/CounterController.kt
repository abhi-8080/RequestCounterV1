package com.q.controller

import com.q.counter.IAtomicCounter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CounterController(val counter: IAtomicCounter) {

    @GetMapping("count")
    fun getNextSequence() = counter.getNextVal()
}