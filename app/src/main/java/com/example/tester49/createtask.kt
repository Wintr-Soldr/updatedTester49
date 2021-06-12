package com.example.tester49

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

import kotlinx.android.synthetic.main.activity_createproject.*
import kotlinx.android.synthetic.main.activity_projects.*
import java.util.*

class createtask : AppCompatActivity()
    {


    lateinit var option : Spinner
    lateinit var result : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createproject)

        option = findViewById<Spinner>(R.id.multiselector)
        result = findViewById<TextView>(R.id.multiselectorresult)




        TaskEditButton.setOnClickListener {
            val intent = Intent(this,TaskTracker::class.java)
            startActivity(intent)
        }

        val depts:Array<String> = arrayOf("Development","Business Development","Affiliate Marketing","UI-UX Design")
        val arrayAdapter=ArrayAdapter(this@createtask,android.R.layout.simple_spinner_dropdown_item,depts)
        deptselectspinner.adapter=arrayAdapter
        deptselectspinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@createtask," "+depts[p2],Toast.LENGTH_LONG).show()

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }



        val selectorlist = arrayOf("Priyal Kumavat","Rupal Singh","Neha Sen","Rohan Gargh","Somali Jain","Vidisha Jha","Ankita Dey","Sonam Das")

        option.adapter=ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,selectorlist)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                result.text=selectorlist.get(p2)

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                result.text = "Please Select Something"

            }
        }







        }


}

