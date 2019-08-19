package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean


@SpringBootApplication
class Application {
	@Bean
	fun myRoutes(builder: RouteLocatorBuilder): RouteLocator = builder.routes()
			// add a simple re-route from: /get to: http://httpbin.org:80
			// add a simple "Hello:World" HTTP Header
			.route{ p ->
				p.path("/get") // intercept calls to the /get path
						.filters{f -> f.addRequestHeader("Hello", "World")} // add header
						.uri("http://httpbin.org:80")
			}.build()
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
