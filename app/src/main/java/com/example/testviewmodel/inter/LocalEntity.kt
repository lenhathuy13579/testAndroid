package com.example.testviewmodel.inter

import com.example.testviewmodel.inter.DomainModel

interface LocalEntity {
    fun toDomainModel(): DomainModel
}