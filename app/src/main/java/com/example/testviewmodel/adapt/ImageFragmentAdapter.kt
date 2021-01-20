package com.example.testviewmodel.adapt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testviewmodel.databinding.ItemImageBinding
import com.example.testviewmodel.domain.Image

class ImageFragmentAdapter() : ListAdapter<Image, ImageFragmentAdapter.ImageListViewHolder>(
    ItemListDiffutil()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        ImageListViewHolder.from(
            parent
        )

    override fun onBindViewHolder(holder: ImageListViewHolder, position: Int) {
        val image = getItem(position)
        holder.binding(image)
    }

    class ImageListViewHolder private constructor(private val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root) {
        fun binding(image: Image) {
            binding.image = image
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ImageListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemImageBinding.inflate(layoutInflater,parent,false)

                return ImageListViewHolder(
                    binding
                )
            }
        }
    }
}
class ItemListDiffutil() : DiffUtil.ItemCallback<Image>() {
    override fun areItemsTheSame(oldItem: Image, newItem: Image) = oldItem.href == newItem.href

    override fun areContentsTheSame(oldItem: Image, newItem: Image) = oldItem == newItem

}