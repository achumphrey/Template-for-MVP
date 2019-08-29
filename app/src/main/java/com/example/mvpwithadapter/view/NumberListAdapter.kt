package com.example.mvpwithadapter.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpwithadapter.R
import com.example.mvpwithadapter.commom.inflate
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class NumberListAdapter(private val list: ArrayList<Int>,
                        private val listener: OnListClickLister
) :
    RecyclerView.Adapter<ListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {

        val view: View = parent.inflate(R.layout.recyclerview_item, false)
        return ListViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.tvNumbers.text = list[position].toString()

        holder.bind(list[position], listener)
    }
}

class ListViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val tvNumbers = view.tv_numbers

    fun bind(number: Int, listener: OnListClickLister) {
        itemView.setOnClickListener {
            listener.onListClick(number)
        }
    }
}

interface OnListClickLister{

    fun onListClick(number: Int)
}