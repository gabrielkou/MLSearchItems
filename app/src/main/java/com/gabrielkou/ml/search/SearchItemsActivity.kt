package com.gabrielkou.ml.search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gabrielkou.ml.R
import com.gabrielkou.ml.mapper.ItemViewMapper
import com.gabrielkou.ml.model.ItemViewModel
import com.gabrielkou.ml.presentation.data.Resource
import com.gabrielkou.ml.presentation.data.ResourceState
import com.gabrielkou.presentation.SearchItemsViewModel
import com.gabrielkou.presentation.model.ItemView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search_items.*
import javax.inject.Inject

class SearchItemsActivity : AppCompatActivity() {

    @Inject
    lateinit var searchAdapter:SearchItemsAdapter
    @Inject
    lateinit var searchItemsViewModel: SearchItemsViewModel
    @Inject lateinit var mapper: ItemViewMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_items)

        AndroidInjection.inject(this)

        searchItemsViewModel = ViewModelProviders.of(this)[SearchItemsViewModel::class.java]

        setupSearchRecycler()
        setupSearchListener()
    }

    override fun onStart() {
        super.onStart()

        searchItemsViewModel.getItems().observe(this, Observer<Resource<List<ItemView>>> {
            it?.let {
                handleDataState(it)
            }
        })
    }

    private fun setupSearchRecycler() {
        recycler_search_results.layoutManager = LinearLayoutManager(this)
        recycler_search_results.adapter = searchAdapter
    }

    private fun setupSearchListener() {
        search_button.setOnClickListener { onItemClicked() }
    }

    private fun onItemClicked() {
        searchItemsViewModel.searchItems(search_edit.text.toString())
    }

    private fun handleDataState(resource: Resource<List<ItemView>>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setupScreenForSuccess(resource.data?.map {
                    mapper.mapToView(it)
                })
            }
            ResourceState.LOADING -> {
                setupScreenForLoadingState()
            }
            ResourceState.ERROR ->{
                setupScreenForError(resource.message)
            }
        }
    }

    private fun updateListView(itemsList: List<ItemViewModel>) {
        searchAdapter.items = itemsList
        searchAdapter.notifyDataSetChanged()
    }

    private fun setupScreenForLoadingState() {
        progress.visibility = View.VISIBLE
        recycler_search_results.visibility = View.GONE
//        view_empty.visibility = View.GONE
//        view_error.visibility = View.GONE
    }

    private fun setupScreenForSuccess(data: List<ItemViewModel>?) {
//        view_error.visibility = View.GONE
        progress.visibility = View.GONE
        if (data != null && data.isNotEmpty()) {
            updateListView(data)
            recycler_search_results.visibility = View.VISIBLE
        } else {
//            view_empty.visibility = View.VISIBLE
        }
    }

    private fun setupScreenForError(message: String?) {
        progress.visibility = View.GONE
        recycler_search_results.visibility = View.GONE
//        view_empty.visibility = View.GONE
//        view_error.visibility = View.VISIBLE
    }
}
