package com.q.counter

import com.q.controller.CounterController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import java.util.stream.IntStream


@SpringBootTest
@AutoConfigureWebTestClient
class RequestCounterApplicationTests {

    @Autowired
    lateinit var controller: CounterController

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Test
    fun contextLoads() {
        assertThat(controller).isNotNull
    }

    @Test
    @DirtiesContext
    fun `get count should return the next increment`() {
        IntStream.range(1, 10).forEach {
            webTestClient.get()
                .uri("/count")
                .exchange()
                .expectStatus().isOk
                .expectBody<Int>().isEqualTo(it)
        }
    }
}
