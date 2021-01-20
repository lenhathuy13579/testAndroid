package com.example.testviewmodel.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testviewmodel.inter.LocalEntity
import com.example.testviewmodel.domain.Image
import com.example.testviewmodel.domain.News
import java.util.*

@Entity(tableName = "new_feed")
data class NewsLocal(@PrimaryKey val document_id: String?,
                     val title: String?,
                     val description: String?,
                     val content_type: String?,
                     val published_date: Date?,
                     val publisher: String?,
                     val origin_url: String?,
                     val avatar: List<Image>?,
                     val content: String?):
    LocalEntity {
    override fun toDomainModel() = News(document_id, title, description, content_type, published_date, publisher, origin_url, avatar, content)
}