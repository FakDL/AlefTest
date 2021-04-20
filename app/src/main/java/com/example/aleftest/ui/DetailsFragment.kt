package com.example.aleftest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.RequestManager
import com.example.aleftest.R
import com.example.aleftest.databinding.FragmentDetailsBinding
import com.example.aleftest.databinding.FragmentListBinding
import com.example.aleftest.ui.recyclerview.ListAdapter
import com.example.aleftest.viewmodels.ListViewModel
import javax.inject.Inject

class DetailsFragment
@Inject constructor(
    requestManager: RequestManager
) : Fragment() {

    private val downloadImageHelper = DownloadImageHelper(requestManager)

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: DetailsFragmentArgs by navArgs()
        val url = args.imageUrl

        downloadImageHelper.setImage(binding.ivPoster, url)
    }

}