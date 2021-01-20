package com.example.testviewmodel.inter

import com.example.testviewmodel.domain.News
import retrofit2.http.GET

interface NewsService {
    @GET("https://raw.githubusercontent.com/Akaizz/static/master/newsfeed.json")
    suspend fun getNews(document_id: String): retrofit2.Response<List<News>>
}