package com.q.controller

import com.q.counter.IAtomicCounter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

@RestController
class CounterController(val counter: IAtomicCounter, val counterExecutor: Executor) {

    @GetMapping("count")
    fun getNextSequence(): CompletableFuture<Int> {
        return CompletableFuture.supplyAsync({ counter.getNextVal() }, counterExecutor)
    }
}