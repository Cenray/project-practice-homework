package com.example.lesson.module2.actuator

import com.example.lesson.module2.meter.UserAddCounter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.endpoint.annotation.Endpoint
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation
import org.springframework.context.annotation.Configuration


@Configuration
@Endpoint(id = "custom-meter", enableByDefault = true)
class CustomMeterEndpoint {

    @Autowired
    private lateinit var userAddCounter: UserAddCounter

    @ReadOperation
    fun meterInfo(): Map<String, String> {
        return mapOf(
            "user.add.counter" to userAddCounter.getCount().toString()
        )
    }

}