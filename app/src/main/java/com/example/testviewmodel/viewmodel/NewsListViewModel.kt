package com.example.testviewmodel.viewmodel

import com.example.testviewmodel.inter.NewsRepository

class NewsListViewMode(private val newsRepository: NewsRepository) {
    val news = newsRepository.getNews()
}