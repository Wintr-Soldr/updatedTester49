package com.example.tester49

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tester49.databinding.ActivityCreateproject2Binding
import kotlinx.android.synthetic.main.activity_createproject2.*
import kotlinx.android.synthetic.main.activity_projects.*

class createproject : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_createproject2)

        val depts:Array<String> = arrayOf("Development","Business Development","Affiliate Marketing","UI-UX Design")
        val arrayAdapter=
            ArrayAdapter(this@createproject,android.R.layout.simple_spinner_dropdown_item,depts)
        departmentspinner.adapter=arrayAdapter
        departmentspinner.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@createproject," "+depts[p2], Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }




        }
    }



