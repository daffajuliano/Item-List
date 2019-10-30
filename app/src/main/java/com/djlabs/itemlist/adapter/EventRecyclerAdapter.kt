package com.djlabs.itemlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.djlabs.itemlist.Data.Item
import com.djlabs.itemlist.R

class EventRecyclerAdapter(var item: MutableList<Item>, var mOnClickListener : OnClickListener) :
    RecyclerView.Adapter<EventRecyclerAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_event_recyclerview, parent, false)

        return EventViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.tvItem.setText(item.get(position).name)
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var tvItem : TextView

        init {
            this.tvItem = itemView.findViewById(R.id.tv_rv_event_item)

            itemView.isClickable = true;
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                mOnClickListener.itemClickListener(position)
            }
        }
    }

    interface OnClickListener {
        fun itemClickListener(position: Int)
    }
}