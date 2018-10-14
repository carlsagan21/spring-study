package com.example.demo.sample

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // no servlet. no tomcat
@AutoConfigureMockMvc // mockmvc test
// WebApplicationContext를 로드하며 내장된 서블릿 컨테이너가 아닌 Mock 서블릿을 제공합니다. @AutoConfigureMockMvc 어노테이션을 함께 사용하면 별다른 설정없이 간편하게 MockMvc를 사용한 테스트를 진행할 수 있습니다.
class SampleControllerTest(
    @Autowired private val mockMvc: MockMvc
) {

    @MockBean
    private lateinit var mockSampleService: SampleService

    @Test
    fun helloAutoConfigureMockMvc() {
        `when`(mockSampleService.getName()).thenReturn("sookiwi")

        mockMvc.perform(get("/hello"))
            .andExpect(status().isOk)
            .andExpect(content().string("hello sookiwi"))
            .andDo(print())
    }
}
