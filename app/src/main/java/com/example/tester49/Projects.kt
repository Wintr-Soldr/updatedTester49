package com.example.tester49

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_createproject.*
import kotlinx.android.synthetic.main.activity_projects.*


class Projects : AppCompatActivity() {

    private var layoutManager:RecyclerView.LayoutManager?=null
    private var adapter:RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)


        // this is back button

        val actionbar = supportActionBar
        actionbar?.title="Project Page"
        actionbar?.setDisplayHomeAsUpEnabled(true)


        //this is for create project button

        createnewprojectbutton.setOnClickListener {
            val intent = Intent(this,createproject::class.java)
            startActivity(intent)
        }


        //this is for the recycle viewer

        layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager

        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter

        val toggler: Button = findViewById(R.id.toggle)
        val blueArrow = resources.getDrawable(R.drawable.arrow_down_blue, theme) as Drawable
        val greenArrow = resources.getDrawable(R.drawable.arrow_down_green, theme) as Drawable
        toggler.setOnClickListener {
            if (toggler.text == "Ongoing") {
                toggler.text = "Completed"
                toggler.setTextColor(Color.parseColor("#09077A"))
                toggler.setCompoundDrawablesWithIntrinsicBounds(blueArrow, null, null, null)
            }
            if (toggler.text == "Completed") {
                toggler.text = "Ongoing"
                toggler.setTextColor(Color.parseColor("#077A27"))
                toggler.setCompoundDrawablesWithIntrinsicBounds(greenArrow, null, null, null)
            }
        }


// this is filterby drop down list
        val depts: Array<String> = arrayOf(
            "All",
            "Development",
            "Business Development",
            "Affiliate Marketing",
            "UI-UX Design",
            "Law Interns"
        )
        val arrayAdapter =
            ArrayAdapter(this@Projects, android.R.layout.simple_spinner_dropdown_item, depts)
        filterbyspinner.adapter=arrayAdapter
        filterbyspinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@Projects," "+depts[p2], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}