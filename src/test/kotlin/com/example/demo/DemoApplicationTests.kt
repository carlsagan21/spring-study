package com.example.demo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@TestPropertySource(
        locations = ["classpath:/test.properties"]
//        properties = ["sookiwi.name=TestSoo"]
)
@SpringBootTest
class DemoApplicationTests(@Autowired private val environment: Environment) {

    @Test
    fun contextLoads() {
        assertThat(environment.getProperty("sookiwi.name"))
                .isEqualTo("TestSoo")
    }

}
