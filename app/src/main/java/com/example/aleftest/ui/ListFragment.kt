package com.example.aleftest.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.example.aleftest.MainActivity
import com.example.aleftest.R
import com.example.aleftest.databinding.FragmentListBinding
import com.example.aleftest.ui.recyclerview.ListAdapter
import com.example.aleftest.viewmodels.ListViewModel
import javax.inject.Inject

class ListFragment @Inject constructor(
    private val viewModelFactory: ViewModelProvider.Factory,
    requestManager: RequestManager
) : Fragment() {
    private val downloadImageHelper = DownloadImageHelper(requestManager)

    private val viewModel: ListViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var listAdapter: ListAdapter

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.fetchData()
    }

    private fun setupAdapter(list: List<String>) {
        val clickLambda: (String) -> Unit = { id ->
            val action = ListFragmentDirections.actionListFragmentToDetailsFragment(id)
            (activity as MainActivity).navHost.navController.navigate(action)
        }
        listAdapter = ListAdapter(clickLambda, downloadImageHelper, list)
        binding.rvFilms.adapter = listAdapter
    }

    private fun setupObservers() {
        viewModel.list.observe (viewLifecycleOwner, {
            setupAdapter(it)
        })
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = true
            viewModel.fetchData()
            binding.swipeRefresh.isRefreshing = false
        }
    }

}
