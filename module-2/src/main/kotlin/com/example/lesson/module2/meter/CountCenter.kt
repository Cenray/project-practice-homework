package com.example.lesson.module2.meter

import io.micrometer.core.instrument.Counter
import io.micrometer.core.instrument.MeterRegistry


class CountCenter(private val name: String, private val tagName: String, private val registry: MeterRegistry) {

    private val map = hashMapOf<String, Counter>()

    fun increase(tagValue: String) {
        return map.getOrPut(tagValue) { Counter.builder(name).tags(tagName, tagValue).register(registry) }.increment()
    }

    fun getCount(tagValue: String): Double = map[tagValue]?.count() ?: 0.0

}