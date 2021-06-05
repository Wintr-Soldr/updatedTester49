package com.example.tester49.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tester49.R
import com.example.tester49.RecyclerAdapter
import com.example.tester49.createtask
import kotlinx.android.synthetic.main.fragment_home.*



class HomeFragment : Fragment() {


    private lateinit var navController: NavController

    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null
    private var HorizontalLayout: LinearLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myFragmentView: View = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = myFragmentView.findViewById(R.id.recycler_view) as RecyclerView
        val activity = activity as Context
        HorizontalLayout = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = HorizontalLayout

        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
        // Inflate the layout for this fragment
        return myFragmentView


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createbutton.setOnClickListener {
            activity?.let {
                val intent=Intent(it,createtask::class.java)
                it.startActivity(intent)

            }
        }

        }
    }



