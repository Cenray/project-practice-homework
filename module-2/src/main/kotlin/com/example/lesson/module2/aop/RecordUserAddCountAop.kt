package com.example.lesson.module2.aop

import com.example.lesson.module2.defaultLog
import com.example.lesson.module2.domain.user.UserEntity
import com.example.lesson.module2.meter.UserAddCounter
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Aspect
@Component
class RecordUserAddCountAop {

    @Autowired
    private lateinit var userAddCounter: UserAddCounter

    @Pointcut("execution(* com.example.lesson.module2.domain.user.UserService.create(..))")
    private fun recordUserAddCountPointCut() = Unit

    @AfterReturning("recordUserAddCountPointCut()", returning = "user")
    fun recordUserAddCount(user: UserEntity) {
        defaultLog.info("AOP监听到用户添加事件: UserEntity(id=${user.id}, name=${user.name})")
        userAddCounter.recordUserAdd()
    }
}