package com.example.testviewmodel.inter

import androidx.lifecycle.LiveData
import com.example.testviewmodel.domain.News


interface NewsRepository {
    suspend fun getNews(document_id: String) : LiveData<List<News>>
}