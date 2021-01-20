package com.example.testviewmodel.adapt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testviewmodel.databinding.ItemNewsBinding
import com.example.testviewmodel.domain.News

class NewsFragmentAdapter() : ListAdapter<News, NewsFragmentAdapter.NewsListViewHolder>(
    NewsListDiffUtil()
){
    class NewsListViewHolder private constructor(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root){
            fun binding(news : News) {
                binding.news = news
                binding.recyclerViewImage.adapter =
                    ImageFragmentAdapter()
                binding.recyclerViewImage.layoutManager = LinearLayoutManager(binding.root.context)
                binding.executePendingBindings()
            }
        companion object {
            fun from(parent: ViewGroup) : NewsListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemNewsBinding.inflate(layoutInflater,parent,false)

                return NewsListViewHolder(
                    binding
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder =
        NewsListViewHolder.from(
            parent
        )

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val news = getItem(position)
        holder.binding(news)
    }
}
class NewsListDiffUtil() : DiffUtil.ItemCallback<News>() {
    override fun areItemsTheSame(oldItem: News, newItem: News) = oldItem.document_id == newItem.document_id

    override fun areContentsTheSame(oldItem: News, newItem: News) = oldItem == newItem

}
