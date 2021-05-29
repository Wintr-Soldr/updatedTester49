package com.example.tester49

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_createproject.*
import kotlinx.android.synthetic.main.activity_projects.*

class Projects : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)


        // this is back button

        val actionbar = supportActionBar
        actionbar?.title="Project Page"
        actionbar?.setDisplayHomeAsUpEnabled(true)


        //this is for create project button

        button3.setOnClickListener {
            val intent = Intent(this,createproject::class.java)
            startActivity(intent)
        }


// this is filterby drop down list
        val depts:Array<String> = arrayOf("Development","Business Development","Affiliate Marketing","UI-UX Design")
        val arrayAdapter=
            ArrayAdapter(this@Projects,android.R.layout.simple_spinner_dropdown_item,depts)
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