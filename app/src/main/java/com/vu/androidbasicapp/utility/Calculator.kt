package com.vu.androidbasicapp.utility

class Calculator(private val logger: Logger) {

    fun add(a: Int, b: Int): Int {
        val result = a + b
        logger.log("Adding $a and $b: $result")

        return result }

    fun subtract(a: Int, b: Int): Int {
        val result = a - b
        logger.log("Subtracting $a and $b: $result")

        return result }
}

class Logger {

    fun log(message: String) {

        // Imagine this logs to a file or console
        println(message)
    }
}
