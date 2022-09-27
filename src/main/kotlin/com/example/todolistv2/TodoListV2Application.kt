package com.example.todolistv2

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class TodoListV2Application

fun main(args: Array<String>) {
    runApplication<TodoListV2Application>(*args)
}
