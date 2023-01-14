package com.example.lesson.module2.domain.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    private lateinit var userRepo: UserRepo

    fun create(name: String) = userRepo.save(UserEntity(name))
    fun list(): MutableList<UserEntity> = userRepo.findAll()
}