package com.aj.bindablerecyclerview.coreui.recyclerviewbinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter(
    value = ["viewList", "isGridView", "columnCount", "isHorizontal"], requireAll = false
)
fun bindItemViewModels(
    recyclerView: RecyclerView,
    itemViewModels: List<RecyclerViewItem>?,
    isGridView: Boolean?,
    columnCount: Int?,
    isHorizontal: Boolean? = false
) {
    val adapter = getorCreateAdapter(recyclerView, isGridView, columnCount, isHorizontal)
    adapter.updateItems(itemViewModels)
    adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
        override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
            super.onItemRangeInserted(positionStart, itemCount)
            recyclerView.scrollToPosition(positionStart)
        }

        override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
            super.onItemRangeRemoved(positionStart, itemCount)
            recyclerView.scrollToPosition(positionStart)
        }

        override fun onItemRangeMoved(fromPosition: Int, toPosition: Int, itemCount: Int) {
            super.onItemRangeMoved(fromPosition, toPosition, itemCount)
            recyclerView.scrollToPosition(fromPosition)
        }
    })
}

private fun getorCreateAdapter(
    recyclerView: RecyclerView,
    isGridView: Boolean?,
    columnCount: Int?,
    isHorizontal: Boolean? = false
): BindableRecyclerViewAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is BindableRecyclerViewAdapter) {
        recyclerView.layoutManager = if (isGridView == true) {
            WrapContentGridLayoutManager(
                recyclerView.context,
                spanCount = columnCount ?: 2,
            )
        } else {
            WrapContentLinearLayoutManager(
                recyclerView.context,
                orientation = if (isHorizontal == true) LinearLayoutManager.HORIZONTAL else LinearLayoutManager.VERTICAL,
                reverseLayout = false
            )
        }
        recyclerView.adapter as BindableRecyclerViewAdapter
    } else {
        val bindableRecyclerAdapter = BindableRecyclerViewAdapter()
        recyclerView.adapter = bindableRecyclerAdapter
        recyclerView.layoutManager = if (isGridView == true) {
            WrapContentGridLayoutManager(
                recyclerView.context, spanCount = columnCount ?: 2
            )
        } else {
            WrapContentLinearLayoutManager(
                recyclerView.context,
                orientation = if (isHorizontal == true) LinearLayoutManager.HORIZONTAL else LinearLayoutManager.VERTICAL,
                reverseLayout = false
            )
        }
        bindableRecyclerAdapter
    }
}
