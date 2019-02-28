package com.gabrielkou.ml.details

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.gabrielkou.ml.R
import com.gabrielkou.ml.injection.ViewModelFactory
import com.gabrielkou.ml.mapper.ItemDetailViewMapper
import com.gabrielkou.ml.model.ItemDetailViewModel
import com.gabrielkou.ml.model.ItemViewModel
import com.gabrielkou.ml.presentation.data.Resource
import com.gabrielkou.ml.presentation.data.ResourceState
import com.gabrielkou.presentation.details.ItemDetailsViewModel
import com.gabrielkou.presentation.model.ItemDetailsView
import com.gabrielkou.presentation.model.ItemView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_item_details.*
import kotlinx.android.synthetic.main.activity_search_items.*
import javax.inject.Inject

class ItemDetailsActivity : AppCompatActivity() {

    @Inject lateinit var itemDetailsViewModel: ItemDetailsViewModel
    @Inject lateinit var itemDetailViewMapper: ItemDetailViewMapper
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var itemId:String
    companion object {
        private val ITEM_ID: String="item_id"

        fun startActivity(context: Context, itemId:String){
            var intent = Intent(context, ItemDetailsActivity::class.java)
            intent.putExtra(ITEM_ID, itemId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)
        AndroidInjection.inject(this)

        itemId = intent.getStringExtra(ITEM_ID)

        itemDetailsViewModel = ViewModelProviders.of(this, viewModelFactory).get(ItemDetailsViewModel::class.java)

    }

    override fun onStart() {
        super.onStart()

        itemDetailsViewModel.getItemDetails(itemId)
        itemDetailsViewModel.getItem().observe(this, Observer<Resource<ItemDetailsView>>{
            it?.let{
                handleDataState(it)
            }
        })
    }

    private fun handleDataState(resource : Resource<ItemDetailsView>) {
        when (resource.status) {
            ResourceState.SUCCESS -> {
                setupScreenForSuccess(itemDetailViewMapper.mapToView(resource.data!!))
            }
            ResourceState.LOADING -> {
                setupScreenForLoadingState()
            }
            ResourceState.ERROR ->{
                setupScreenForError(resource.message)
            }
        }
    }

    private fun setupScreenForError(message: String?) {
        detail_progress.visibility = View.GONE
    }

    private fun setupScreenForLoadingState() {
        detail_progress.visibility = View.VISIBLE
//        recycler_search_results.visibility = View.GONE
//        view_empty.visibility = View.GONE
//        view_error.visibility = View.GONE
    }

    private fun setupScreenForSuccess(data: ItemDetailViewModel) {
//        view_error.visibility = View.GONE
        detail_progress.visibility = View.GONE
        updateView(data)
//        recycler_search_results.visibility = View.VISIBLE
    }

    private fun updateView(data: ItemDetailViewModel) {
        if (data.title!= null)
            detail_title.text = data.title

        if (data.price!= null)
            detail_price.text = data.price

        if (data.seller != null)
            detail_seller.text = data.seller

    }

}
