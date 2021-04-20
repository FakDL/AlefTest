package com.example.aleftest.ui.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.aleftest.databinding.ItemImageBinding
import com.example.aleftest.ui.DownloadImageHelper

class ListAdapter(
    val clickLambda: (url: String) -> Unit,
    private val downloadImageHelper: DownloadImageHelper,
    private var list: List<String>
) : RecyclerView.Adapter<ImageHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder =
        ImageHolder.create(parent, clickLambda, downloadImageHelper)


    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

}

class ImageHolder(
    private val binding: ItemImageBinding,
    private val clickLambda: (String) -> Unit,
    private val downloadImageHelper: DownloadImageHelper
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(url: String, position: Int) {
        downloadImageHelper.setImage(binding.ivPoster, url)
        itemView.setOnClickListener { clickLambda(url) }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            clickLambda: (String) -> Unit,
            downloadImageHelper: DownloadImageHelper
        ): ImageHolder = ImageHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            clickLambda,
            downloadImageHelper
        )

    }
}
