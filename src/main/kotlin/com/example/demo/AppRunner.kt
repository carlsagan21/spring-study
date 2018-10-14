package com.example.demo

import org.slf4j.LoggerFactory
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
//    private val sookiwiProperties: SookiwiProperties,
    private val configurationString: String
) : ApplicationRunner {

    private val logger = LoggerFactory.getLogger(AppRunner::class.java)

    override fun run(args: ApplicationArguments?) {
        logger.debug("ApplicationRunner")
        logger.debug(args?.toString())
//        To get platform type. https://kotlinlang.org/docs/reference/java-interop.html
//        @NotNull or @NotEmpty is used to avoid null
//        val name: String? = sookiwiProperties.name
//        val age: Int? = sookiwiProperties.age
//        val fullName: String? = sookiwiProperties.fullName
//        val sessionTimeout: Duration? = sookiwiProperties.sessionTimeout
//        logger.debug(sookiwiProperties.name)
//        println(sookiwiProperties.age)
//        println(sookiwiProperties.fullName)
//        println(sookiwiProperties.sessionTimeout)
        logger.debug(configurationString)
    }
}
