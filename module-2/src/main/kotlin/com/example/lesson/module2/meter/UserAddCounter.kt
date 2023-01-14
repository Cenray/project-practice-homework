package com.example.lesson.module2.meter

import io.micrometer.core.instrument.simple.SimpleMeterRegistry
import org.springframework.stereotype.Component


@Component
class UserAddCounter {

    private val registry = SimpleMeterRegistry()
    private val counter = CountCenter("user", "add", registry)
    private val tagValue = "count"

    fun recordUserAdd() = counter.increase(tagValue)
    fun getCount(): Double = counter.getCount(tagValue)
}