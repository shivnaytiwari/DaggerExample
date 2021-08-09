package com.missingsemicollon.daggerexample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.missingsemicollon.daggerexample.R
import com.missingsemicollon.daggerexample.network.User
import kotlinx.android.synthetic.main.simple_list_item_1.view.*

class UsersAdapter(private val users: ArrayList<User>?) :
    RecyclerView.Adapter<UsersAdapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.simple_list_item_1, parent, false)
        return ItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemView.text1.text = users?.get(position)?.email ?: ""
    }

    override fun getItemCount() = users?.size ?: 0
}