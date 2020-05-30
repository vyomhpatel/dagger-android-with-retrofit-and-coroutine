package com.vyom.practice.search

import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.vyom.practice.R
import com.vyom.practice.databinding.ActivitySearchBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class SearchActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: SearchActivityViewModel

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivitySearchBinding>(this, R.layout.activity_search).also {
            binding = it
        }.apply { lifecycleOwner = this@SearchActivity }
        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        )[SearchActivityViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        binding.searchButton.setOnClickListener {
            binding.searchTermInput.text?.let {
                viewModel.getResponse(it.toString()).observe(this) { result ->
                    result.fold({ data ->
                        binding.resultText.text = data.query.searchinfo.totalhits.toString()
                    }, {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}
