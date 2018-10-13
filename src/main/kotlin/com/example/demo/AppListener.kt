package com.example.demo

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.ApplicationListener
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component

@Component
class AppListener : ApplicationListener<ApplicationStartedEvent> {

    override fun onApplicationEvent(event: ApplicationStartedEvent) {
        println("ApplicationStartedEvent")
    }
}

@Component
@Order(1)
class AppRunner(
//    @Value("\${sookiwi.name}") private val name: String? = null,
    private val sookiwiProperties: SookiwiProperties,
    private val configurationString: String
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        println("ApplicationRunner")
        println(args)
//        To get platform type. https://kotlinlang.org/docs/reference/java-interop.html
//        @NotNull or @NotEmpty is used to avoid null
//        val name: String? = sookiwiProperties.name
//        val age: Int? = sookiwiProperties.age
//        val fullName: String? = sookiwiProperties.fullName
//        val sessionTimeout: Duration? = sookiwiProperties.sessionTimeout
        println(sookiwiProperties.name)
//        println(sookiwiProperties.age)
//        println(sookiwiProperties.fullName)
//        println(sookiwiProperties.sessionTimeout)
        println(configurationString)
    }
}
