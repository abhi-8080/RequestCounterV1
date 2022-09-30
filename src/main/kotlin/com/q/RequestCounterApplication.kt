package com.q

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RequestCounterApplication

fun main(args: Array<String>) {
    runApplication<RequestCounterApplication>(*args)
}
