package com.example.demo.sample

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// EmbeddedWebApplicationContext를 로드하며 실제 서블릿 환경을 구성합니다. 생성된 서블릿 컨테이너는 임의의 포트는 listen합니다.
class SampleIntegrationTest(
//    @Autowired private val testRestTemplate: TestRestTemplate,
    @Autowired private val webTestClient: WebTestClient
) {

    @MockBean
    private lateinit var mockSampleService: SampleService

//    @Test
//    fun hello() {
//        `when`(mockSampleService.getName()).thenReturn("sookiwi")
//
//        assertThat(testRestTemplate.getForObject<String>("/hello")).isEqualTo("hello sookiwi")
//    }

    @Test
    fun helloWtc() {
        `when`(mockSampleService.getName()).thenReturn("sookiwi wtc")

        webTestClient.get().uri("/hello").exchange()
            .expectStatus().isOk
            .expectBody<String>().isEqualTo("hello sookiwi wtc")
    }
}
