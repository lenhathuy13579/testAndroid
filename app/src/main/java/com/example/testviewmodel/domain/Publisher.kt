package com.example.testviewmodel.domain

import com.example.testviewmodel.entity.PublisherLocal
import com.example.testviewmodel.inter.DomainModel
import com.example.testviewmodel.inter.LocalEntity

data class Publisher(val id: String?, val name: String?, val icon: String?): DomainModel {
    override fun toLocalEntity(): LocalEntity = PublisherLocal(id, name, icon)
}