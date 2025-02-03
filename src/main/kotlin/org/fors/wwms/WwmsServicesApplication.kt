package org.fors.wwms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WwmsServicesApplication

fun main(args: Array<String>) {
    runApplication<WwmsServicesApplication>(*args)
}
