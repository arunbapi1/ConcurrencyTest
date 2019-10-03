package com.example.concurrencytestapi


import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.concurrencytestapi.model.ItemModel
import com.example.concurrencytestapi.network.ApiErrorResponse
import com.example.concurrencytestapi.network.ApiIsLoading
import com.example.concurrencytestapi.network.ApiResponse
import com.example.concurrencytestapi.network.ApiSuccessResponse
import com.example.concurrencytestapi.repository.ConcurrencyRepository
import com.example.concurrencytestapi.ui.MainActivityViewModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityViewModelTest {
    var newsRepository: ConcurrencyRepository = mock()
    lateinit var viewModel: MainActivityViewModel
    var apiResponseObserver: Observer<ItemModel?> = mock()
    var data = MutableLiveData<ApiResponse<ItemModel>>()

    @Rule
    @JvmField  val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        whenever(newsRepository.getAllProfessionData()).thenReturn(data)
        viewModel = MainActivityViewModel(newsRepository)
        viewModel.response.observeForever(apiResponseObserver)
    }

    @Test
    fun testIfApiIsLoading() {
        data.value = ApiIsLoading()
        assert(viewModel.showLoader.value == View.VISIBLE)
    }

    @Test
    fun testSuccessResponse() {
        data.value = ApiSuccessResponse(ItemModel(listOf()))
        verify(apiResponseObserver).onChanged(ItemModel(listOf()))
    }



    @Test
    fun testErrorResponse() {
        data.value = ApiErrorResponse(Exception())
        assert(viewModel.showLoader.value == View.GONE)
    }
}