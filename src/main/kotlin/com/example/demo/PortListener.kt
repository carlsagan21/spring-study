package com.example.demo

import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component


@Component
class PortListener : ApplicationListener<ServletWebServerInitializedEvent> {
    override fun onApplicationEvent(event: ServletWebServerInitializedEvent) {
        println(event.applicationContext.webServer.port)
    }
}