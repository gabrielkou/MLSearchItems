package com.gabrielkou.ml.search

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.gabrielkou.ml.details.ItemDetailsActivity
import com.gabrielkou.ml.injection.ViewModelFactory
import com.gabrielkou.ml.mapper.ItemViewMapper
import com.gabrielkou.ml.model.ItemViewModel
import com.gabrielkou.ml.presentation.data.Resource
import com.gabrielkou.ml.presentation.data.ResourceState
import com.gabrielkou.presentation.search.SearchItemsViewModel
import com.gabrielkou.presentation.model.ItemView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_search_items.*
import javax.inject.Inject
import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.gabrielkou.ml.R


class SearchItemsActivity : AppCompatActivity() {

    @Inject lateinit var searchAdapter:SearchItemsAdapter
    @Inject lateinit var searchItemsViewModel: SearchItemsViewModel
    @Inject lateinit var mapper: ItemViewMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_items)

        AndroidInjection.inject(this)

        searchItemsViewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchItemsViewModel::class.java)

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
        searchAdapter.itemListener = itemListener
        recycler_search_results.layoutManager = LinearLayoutManager(this)
        recycler_search_results.adapter = searchAdapter
    }

    private fun setupSearchListener() {
        search_button.setOnClickListener { onSearchButtonClicked() }
    }

    private fun onSearchButtonClicked() {
        searchItemsViewModel.searchItems(search_edit.text.toString())
        dismissKeyboard()
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

    private fun dismissKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm!!.hideSoftInputFromWindow(search_edit.getWindowToken(), 0)
    }

    private fun setupScreenForError(message: String?) {
        progress.visibility = View.GONE
        recycler_search_results.visibility = View.GONE
//        view_empty.visibility = View.GONE
//        view_error.visibility = View.VISIBLE
    }




    private val itemListener = object :ItemListener{
        override fun onItemClicked(itemId: String) {
            ItemDetailsActivity.startActivity(this@SearchItemsActivity, itemId)
        }
    }

}
