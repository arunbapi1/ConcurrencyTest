package com.example.concurrencytestapi.ui

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.concurrencytestapi.SingleLiveEvent
import com.example.concurrencytestapi.model.ItemModel
import com.example.concurrencytestapi.repository.ConcurrencyRepository
import com.example.concurrencytestapi.switchMapForApiResponse

/**
 * @author Created by Arun
 * View Model class used to fetch API using Transformation through Live Data.
 */
class MainActivityViewModel constructor (val newsRepository: ConcurrencyRepository) : ViewModel() {

    val showLoader = MutableLiveData<Int>()
    var response: LiveData<ItemModel?>
    val loadData : SingleLiveEvent<Unit> = SingleLiveEvent()
    val errorTvVisibility = MutableLiveData<Int>()

    init {
        response = Transformations.switchMap(loadData){
            switchMapForApiResponse(newsRepository.getAllProfessionData(), doOnSuccess = {
                showLoader.value = View.GONE
                errorTvVisibility.value = View.GONE
                return@switchMapForApiResponse it
            }, doOnSubscribe = {
                showLoader.value = View.VISIBLE
                errorTvVisibility.value = View.GONE
            }, doOnError = {
                showLoader.value = View.GONE
                errorTvVisibility.value = View.VISIBLE
            })
            }
        loadData.call()
    }

    companion object {
        @JvmStatic
        @BindingAdapter("bind:response")
        fun bindListAdapter(reyclerView: RecyclerView, response: ItemModel?) {
            if (response != null)
                reyclerView.adapter = ListAdapter(response)
        }
    }

}