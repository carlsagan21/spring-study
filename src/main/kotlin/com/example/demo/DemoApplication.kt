package com.example.demo

import com.example.demo.blog.*
import org.springframework.boot.Banner
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args) {
        // customization
         setBannerMode(Banner.Mode.OFF)
    }

}

@Bean
fun databaseInitializer(
        userRepository: UserRepository,
        articleRepository: ArticleRepository
) = CommandLineRunner {
    val smaldini = User("smaldini", "Stéphane", "Maldini")
    userRepository.save(smaldini)

    articleRepository.save(Article(
            "Reactor Bismuth is out",
            "Lorem ipsum",
            "dolor **sit** amet https://projectreactor.io/",
            smaldini,
            1
    ))
    articleRepository.save(Article(
            "Reactor Aluminium has landed",
            "Lorem ipsum",
            "dolor **sit** amet https://projectreactor.io/",
            smaldini,
            2
    ))
}
