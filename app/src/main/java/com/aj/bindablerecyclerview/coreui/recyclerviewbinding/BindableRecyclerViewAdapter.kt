package com.aj.bindablerecyclerview.coreui.recyclerviewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR

class BindableRecyclerViewAdapter : RecyclerView.Adapter<BindableViewHolder>() {

    private val mDiffer: AsyncListDiffer<RecyclerViewItem> =
        AsyncListDiffer(this, object : DiffUtil.ItemCallback<RecyclerViewItem>() {
            override fun areItemsTheSame(
                oldItem: RecyclerViewItem,
                newItem: RecyclerViewItem
            ): Boolean {
                return oldItem.areItemsTheSame(newItem)
            }

            override fun areContentsTheSame(
                oldItem: RecyclerViewItem,
                newItem: RecyclerViewItem
            ): Boolean {
                return oldItem.areContentTheSame(newItem)
            }
        })
    var recyclerViewItems: List<RecyclerViewItem> = emptyList()
    private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewTypeToLayoutId[viewType] ?: 0,
            parent,
            false
        )
        return BindableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        holder.bind(recyclerViewItems[position])
    }

    fun updateItems(item: List<RecyclerViewItem>?) {
        recyclerViewItems = item.orEmpty().toMutableList()
        mDiffer.submitList(recyclerViewItems)
    }

    override fun getItemViewType(position: Int): Int {
        val item = recyclerViewItems[position]
        if(!viewTypeToLayoutId.containsKey(item.viewType)){
            viewTypeToLayoutId[item.viewType] = item.layoutId
        }
        return item.viewType
    }

    override fun getItemCount(): Int = recyclerViewItems.size

}

class BindableViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(
    binding.root
) {
    fun bind(rvItem: RecyclerViewItem) {
        binding.setVariable(BR.viewModel, rvItem)
    }
}