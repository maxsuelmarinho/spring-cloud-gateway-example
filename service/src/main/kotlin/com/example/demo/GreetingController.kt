package com.example.demo

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong


@RestController
class GreetingController(val counter: AtomicLong = AtomicLong()) {

    companion object {
        const val TEMPLATE = "Hello, %s!"
    }

    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value="name", defaultValue="World") name: String) =
            Greeting(counter.incrementAndGet(), String.format(GreetingController.TEMPLATE, name))
}