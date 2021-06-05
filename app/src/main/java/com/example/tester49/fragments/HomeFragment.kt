package com.example.tester49.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import com.example.tester49.Projects
import com.example.tester49.R
import com.example.tester49.createtask
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        //val dat = arrayOf("Text to be displayed here","Text to be displayed here","Text to be displayed here")
        //updatescroll.layoutManager=layoutManager
        //val adapter=CustomAdapter(dat.toList())
        //updatescroll.setHasFixedSize(true)



        //updatescroll.adapter=adapter


        }








    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)



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



