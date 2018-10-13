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
class AppRunner : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        println("ApplicationRunner")
        println(args)
    }

}
