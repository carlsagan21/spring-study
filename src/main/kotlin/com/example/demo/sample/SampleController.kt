package com.example.demo.sample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SampleController(
    private val sampleService: SampleService
) {

    @GetMapping("/hello")
    fun hello(): String = "hello " + sampleService.getName()
}
