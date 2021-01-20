package com.example.testviewmodel.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.testviewmodel.domain.News
import com.example.testviewmodel.entity.NewsLocal
@Dao
abstract class NewsDao {
    @Query("SELECT * FROM new_feed")
    abstract fun getNews(document_id: String): LiveData<List<News>>
}