package com.example.prograsemana18

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.prograsemana18.databinding.ItemholderBinding


class ViewPager (
    private val context: Context,
    private val labelList: MutableList<String>,
    private val backList: MutableList<String>
): RecyclerView.Adapter<ViewPager.ViewPageHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPageHolder {
        val binding = ItemholderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPageHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewPageHolder, position: Int) {
        val label = labelList[position]
        val back = backList[position]
        holder.bind(label,back)
    }
    override fun getItemCount(): Int {
        return labelList.size
    }
    class ViewPageHolder(private var itemHolderBinding: ItemholderBinding) :
        RecyclerView.ViewHolder(itemHolderBinding.root) {
        fun bind(label: String, back: String) {
            itemHolderBinding.label.text = label
            itemHolderBinding.root.setBackgroundColor(Color.parseColor(back))
        }
    }
}