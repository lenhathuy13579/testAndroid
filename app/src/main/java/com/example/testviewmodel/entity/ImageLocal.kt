package com.example.testviewmodel.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testviewmodel.domain.Image
import com.example.testviewmodel.inter.DomainModel
import com.example.testviewmodel.inter.LocalEntity

@Entity(tableName = "image")
data class ImageLocal(@PrimaryKey val href:String?, val main_color: String?, val width: Int, val height: Int): LocalEntity {
    override fun toDomainModel(): DomainModel = Image(href, main_color, width, height)
}