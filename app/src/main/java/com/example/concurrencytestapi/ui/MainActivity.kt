package com.example.concurrencytestapi.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.concurrencytestapi.R
import com.example.concurrencytestapi.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * @author Created by Arun
 * Class to create activity to have first UI screen.
 */
class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModelFactory : MainActivityViewModelFactory
    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initDataBinding()
    }

    /**
     * Used to initialize the view, DataBinding & ViewModel.
     * */
    private fun initDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        viewModel = ViewModelProviders.of(this, viewModelFactory)[MainActivityViewModel::class.java]
        binding.viewModel = viewModel
    }
}