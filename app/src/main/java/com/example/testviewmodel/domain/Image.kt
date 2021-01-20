package com.example.testviewmodel.domain

import com.example.testviewmodel.entity.ImageLocal
import com.example.testviewmodel.inter.DomainModel
import com.example.testviewmodel.inter.LocalEntity

data class Image(val href:String? = null,
                 val main_color: String? = null,
                 val width: Int,
                 val height: Int): DomainModel {
    override fun toLocalEntity(): LocalEntity = ImageLocal(href, main_color, width, height)
}