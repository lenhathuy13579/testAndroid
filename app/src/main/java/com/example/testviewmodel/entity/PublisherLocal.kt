package com.example.testviewmodel.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testviewmodel.domain.Publisher
import com.example.testviewmodel.inter.DomainModel
import com.example.testviewmodel.inter.LocalEntity


@Entity(tableName = "publisher")
data class PublisherLocal(@PrimaryKey val id: String? = null,
                          val name: String? = null,
                          val icon: String? = null): LocalEntity {
    override fun toDomainModel(): DomainModel =  Publisher(id, name, icon)
}