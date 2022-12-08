package com.example.users.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.users.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.Observer
import com.example.users.ui.main.MainViewModel.UiModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getUsers()
        adapter = UserAdapter(listOf())
        binding.recycler.adapter = adapter
        viewModel.model.observe(this, Observer(::updateUi))

    }

    private fun updateUi(model: UiModel) {
        binding.progress.visibility = if (model is UiModel.Loading) View.VISIBLE else View.GONE

        when (model) {
            is UiModel.Content -> {
                adapter = UserAdapter(model.users)
                binding.recycler.setHasFixedSize(true)
                binding.recycler.adapter = adapter
            }
            else -> {}
        }
    }
}