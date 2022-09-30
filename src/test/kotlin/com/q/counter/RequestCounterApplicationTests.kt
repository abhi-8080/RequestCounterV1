package com.q.counter

import com.q.controller.CounterController
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.stream.IntStream


@SpringBootTest
@AutoConfigureMockMvc
class RequestCounterApplicationTests {

    @Autowired
    lateinit var controller: CounterController

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
        assertThat(controller).isNotNull
    }

    @Test
    @DirtiesContext
    fun `get count should return the next increment`() {
        IntStream.range(1, 10).forEach {
            mockMvc.perform(get("/count")).andExpect(status().isOk)
                .andExpect(content().string(`is`("$it")))
        }
    }
}
