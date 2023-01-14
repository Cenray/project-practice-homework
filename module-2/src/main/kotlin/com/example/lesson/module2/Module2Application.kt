package com.example.lesson.module2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.logging.Logger

@SpringBootApplication
class Module2Application


fun main(args: Array<String>) {
    runApplication<Module2Application>(*args)
}

val defaultLog: Logger = Logger.getLogger(Module2Application::class.qualifiedName)