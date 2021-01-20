package com.example.testviewmodel.viewmodel

import androidx.lifecycle.*
import com.example.testviewmodel.AppDispatchers
import com.example.testviewmodel.GetNewsUsecase
import com.example.testviewmodel.domain.News
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val dispatchers: AppDispatchers, private val getNewsUsecase: GetNewsUsecase) : ViewModel() {
    private val _news = MediatorLiveData<News>()
    val newsGet: LiveData<News> get()  = _news
    private var newsSource: LiveData<List<News>> = MutableLiveData()
    val id = "7wx5m2emp3r"
    init {
        getNews(id)
    }

    private fun getNews(document_id: String){
        viewModelScope.launch(dispatchers.main) {
            _news.removeSource(newsSource)
            withContext(dispatchers.io) {

                newsSource = getNewsUsecase(document_id)
            }
        }
    }

}