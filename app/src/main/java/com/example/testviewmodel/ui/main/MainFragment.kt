package com.example.testviewmodel.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testviewmodel.*
import com.example.testviewmodel.adapt.NewsFragmentAdapter
import com.example.testviewmodel.databinding.MainFragmentBinding
import com.example.testviewmodel.inter.NewsService
import com.example.testviewmodel.viewmodel.MainViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainFragment : Fragment() {


    private val retrofit = Retrofit.Builder()
                .client(OkHttpClient())
        .baseUrl("https://raw.githubusercontent.com/Akaizz/static/master/newsfeed.json")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    private lateinit var binding: MainFragmentBinding
    companion object {
        fun newInstance() = MainFragment()
    }

    private val service = retrofit.create(NewsService::class.java)
    private val dataSource = NewsDataSource(service)

    private val database = NewsDatabase.getDatabase(requireContext())
    private val postDao = database.newsDao()
    private val postRepository = NewsRepositoryImpl(postDao)

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = MainFragmentBinding.inflate(inflater,container,false)
        binding.news = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        with(binding.recyclerViewNews) {
            adapter = NewsFragmentAdapter()
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}