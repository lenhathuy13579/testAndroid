package com.example.testviewmodel.adapt

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testviewmodel.adapt.ImageFragmentAdapter
import com.example.testviewmodel.adapt.NewsFragmentAdapter
import com.example.testviewmodel.domain.Image
import com.example.testviewmodel.domain.News

@BindingAdapter("android:News")
fun getNews(recyclerView: RecyclerView, news: List<News>){
    if (recyclerView.adapter != null && news != null){
        (recyclerView as? NewsFragmentAdapter)?.submitList(news)
    }
}

@BindingAdapter("android:Image")
fun getImage(recyclerView: RecyclerView, image: List<Image>){
    if (recyclerView.adapter != null && image != null){
        (recyclerView as? ImageFragmentAdapter)?.submitList(image)
    }
}