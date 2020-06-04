package com.bapidas.news.base.adapter.recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bapidas.news.BR

class BaseViewHolder<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T?, clickListener: Any) {
        binding.setVariable(BR.item, item)
        binding.setVariable(BR.callback, clickListener)
        binding.executePendingBindings()
    }

    fun getBinding(): ViewDataBinding = binding
}
