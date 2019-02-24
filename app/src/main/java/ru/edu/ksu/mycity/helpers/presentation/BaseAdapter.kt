package ru.edu.ksu.mycity.helpers.presentation

import androidx.recyclerview.widget.RecyclerView


abstract class BaseAdapter<VH : RecyclerView.ViewHolder, MODEL_TYPE> : RecyclerView.Adapter<VH>() {

    protected var itemsList = listOf<MODEL_TYPE>()

    fun setItems(items: List<MODEL_TYPE>?) {
        itemsList = items ?: emptyList()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = itemsList.size
}