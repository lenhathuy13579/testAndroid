package com.example.testviewmodel

import androidx.lifecycle.LiveData
import com.example.testviewmodel.data.dao.NewsDao
import com.example.testviewmodel.domain.News
import com.example.testviewmodel.inter.NewsRepository

class NewsRepositoryImpl(private val newsDao: NewsDao):
    NewsRepository {

    override suspend fun getNews(document_id: String): LiveData<List<News>> {
        return newsDao.getNews(document_id)
    }
}