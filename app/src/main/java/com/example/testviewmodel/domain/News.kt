package com.example.testviewmodel.domain


import com.example.testviewmodel.inter.DomainModel
import com.example.testviewmodel.entity.NewsLocal
import java.util.*

data class News(val document_id: String? = null,
                val title: String? = null,
                val description: String? = null ,
                val content_type: String? = null,
                val published_date: Date? = null,
                val publisher: String? = null,
                val origin_url: String? = null,
                val avatar: List<Image>? = null,
                val content: String? = null):
    DomainModel {
    override fun toLocalEntity() = NewsLocal(document_id, title, description, content_type, published_date, publisher, origin_url, avatar, content)
}