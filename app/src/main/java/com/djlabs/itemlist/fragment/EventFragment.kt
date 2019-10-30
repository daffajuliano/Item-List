package com.djlabs.itemlist.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.djlabs.itemlist.Data.Item
import com.djlabs.itemlist.R
import com.djlabs.itemlist.adapter.EventRecyclerAdapter


/**
 * A simple [Fragment] subclass.
 */
class EventFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item : MutableList<Item> = ArrayList<Item>()
        item.add(Item("Item 1"))
        item.add(Item("Item 2"))
        item.add(Item("Item 3"))
        item.add(Item("Item 4"))

        recyclerView = view.findViewById(R.id.rv_event)
        val adapter = EventRecyclerAdapter(item)
        val lnm = LinearLayoutManager(view.context);
        recyclerView.layoutManager = lnm
        recyclerView.adapter = adapter
    }
}
