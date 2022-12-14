package com.q.config

import com.q.counter.IAtomicCounter
import com.q.counter.SimpleCounter
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.Executor
import java.util.concurrent.ForkJoinPool


@Configuration
class Config {

    @Bean
    @ConditionalOnMissingBean(IAtomicCounter::class)
    fun counterBean(): IAtomicCounter = SimpleCounter()

    @Bean(name = ["counterExecutor"])
    fun getAsyncExecutor(): Executor = ForkJoinPool.commonPool()
}