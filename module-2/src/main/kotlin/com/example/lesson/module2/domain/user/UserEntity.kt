package com.example.lesson.module2.domain.user

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
class UserEntity(
    var name: String,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    lateinit var id: String

}