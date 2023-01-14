package com.example.lesson.module2

import com.example.lesson.module2.domain.user.UserService
import com.example.lesson.module2.meter.UserAddCounter
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@SpringBootTest
@ExtendWith(SpringExtension::class)
class UserAddTests {

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var userAddCounter: UserAddCounter

    @Test
    fun test() {
        userService.create("123")
        userService.create("321")

        defaultLog.info("用户添加计数器: ${userAddCounter.getCount()}")
        userService.list().forEach { jacksonObjectMapper().writeValueAsString(it) }
    }

}