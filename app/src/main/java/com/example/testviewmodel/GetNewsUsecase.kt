package com.example.testviewmodel

import com.example.testviewmodel.inter.NewsRepository

class GetNewsUsecase(private val repository: NewsRepository) {
    suspend operator fun invoke(document_id: String) = repository.getNews(document_id)
}