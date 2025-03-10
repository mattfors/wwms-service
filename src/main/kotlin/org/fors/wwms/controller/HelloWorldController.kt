package org.fors.wwms.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class HelloWorldController {
    @GetMapping("/hello")
    fun helloWorld(): String {
        return "Hello, World!"
    }
}