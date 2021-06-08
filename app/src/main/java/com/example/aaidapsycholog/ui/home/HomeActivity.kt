package com.example.aaidapsycholog.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aaidapsycholog.databinding.ActivityHomeBinding
import com.example.aaidapsycholog.ui.tweet.CaseAdapter
import com.example.aaidapsycholog.ui.tweet.CaseViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: CaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Aaida"
        showListView()

    }

    private fun showListView() {
        val caseAdapter = CaseAdapter()
        Log.d("testcase", "testcase")
        with(binding.rvListTwit) {
            adapter = caseAdapter
            layoutManager = LinearLayoutManager(this@HomeActivity)
            setHasFixedSize(true)
            viewModel.getListTwitterUser().observe(this@HomeActivity, { data ->
                Log.d("cek data",data.toString())
                if (data.isNotEmpty()){
                    caseAdapter.setCase(data)
                }
            })
        }
    }
}