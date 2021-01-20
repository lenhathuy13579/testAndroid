package com.example.testviewmodel

import com.example.testviewmodel.domain.News
import com.example.testviewmodel.inter.NewsService
import retrofit2.Response

class NewsDataSource(private val service: NewsService) {
    suspend fun getNews(document_id: String): Response<News> =service.getNews(document_id)
}