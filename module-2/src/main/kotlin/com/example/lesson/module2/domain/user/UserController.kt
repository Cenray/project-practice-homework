package com.example.lesson.module2.domain.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController {


    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/add/{count}")
    fun add(@PathVariable count: String): Int {
        val times = count.toIntOrNull() ?: 1
        repeat(times) { userService.create(System.currentTimeMillis().toString()) }
        return times
    }

    @GetMapping("/list")
    fun list() = userService.list()

}