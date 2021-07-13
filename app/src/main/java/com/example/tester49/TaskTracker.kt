package com.example.tester49

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_task_tracker.*
//TT
class TaskTracker : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<TaskViewAdapter.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_tracker)


        layoutManager= LinearLayoutManager(this)
        taskView.layoutManager=layoutManager

        adapter= TaskViewAdapter()
        taskView.adapter=adapter

        val ar=resources.getStringArray(R.array.taskviewdropdwn)
        val arrayAdapter=ArrayAdapter(this,R.layout.dropdown_item,ar)
        autoCompleteTextView4.setAdapter(arrayAdapter)






    }
}