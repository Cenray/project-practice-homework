package com.example.lesson.module2.domain.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<UserEntity, String>