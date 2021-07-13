package com.example.tester49

import android.app.DatePickerDialog
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tester49.databinding.ActivityDropdownBinding
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
//dropd

class Dropdown : AppCompatActivity() {
    private lateinit var binding: ActivityDropdownBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDropdownBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val departments = resources.getStringArray(R.array.department)
        val adapter1 = ArrayAdapter(this, R.layout.dropdown_item1, departments)
        binding.autoCompleteTextView1.setAdapter(adapter1)

        val developers = resources.getStringArray(R.array.developers)
        val adapter2 = ArrayAdapter(this, R.layout.dropdown_item1, developers)
        binding.autoCompleteTextView2.setAdapter(adapter2)

        val selectPeople = applicationContext.resources.getStringArray(R.array.listarray)
        val categoryModelArrayList = ArrayList<CategoryModel>()
        for (s in selectPeople) {
            val categoryModel = CategoryModel()
            categoryModel.setTitle(s)
            categoryModel.setSelected(false)
            categoryModelArrayList.add(categoryModel)
        }
        val myAdapter = MyAdapter(this@Dropdown, 0, categoryModelArrayList)
        binding.autoCompleteTextView3.setAdapter(myAdapter)
        val sharedPreferences = this.getPreferences(MODE_PRIVATE)
        val category = sharedPreferences.all as Map<String, *>
        Toast.makeText(applicationContext, "" + category, Toast.LENGTH_LONG).show()

        val vis: TextView = binding.varvisibletext
        if (category.isEmpty()) {
            vis.visibility = View.VISIBLE
        } else {
            vis.visibility = View.GONE
        }

        val gridList: GridView = findViewById(R.id.grid_list)
        val values = ArrayList<String>()
        for(key in category.keys){
            values.add(key)
        }
        gridList.adapter = ArrayAdapter(this, R.layout.grid_item, values)
        val saveButton = findViewById<Button>(R.id.save_button)
        onButtonClick(saveButton)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val cal1: ImageButton = findViewById(R.id.cal1)
        val startingDateText: EditText = findViewById(R.id.startingDateText)

        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val currentDateAndTime: String = simpleDateFormat.format(Date())
        startingDateText.setText(currentDateAndTime)

        val cal2: ImageButton = findViewById(R.id.cal2)
        val estDateText: EditText = findViewById(R.id.estDateText)

        estDateText.setText(currentDateAndTime)

        cal1.setOnClickListener(View.OnClickListener {
            val datePickerDialog = DatePickerDialog(
                this@Dropdown,
                { view, year, month, dayOfMonth -> //sets date in EditText
                    startingDateText.setText(dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                }, year, month, day
            )
            //shows DatePickerDialog
            datePickerDialog.show()
        })

        cal2.setOnClickListener(View.OnClickListener {
            val datePickerDialog = DatePickerDialog(this@Dropdown,
                { view, year, month, dayOfMonth -> //sets date in EditText
                    estDateText.setText(dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                }, year, month, day
            )
            //shows DatePickerDialog
            datePickerDialog.show()
        })
    }
    fun onButtonClick(v :View?) {

        //get reference to TextView
        val textInputLayout = findViewById<TextInputLayout>(R.id.taskNameBox)
        val taskName: String = textInputLayout.editText!!.text.toString()
        val textInputLayoutmenu1 = findViewById<TextInputLayout>(R.id.menu1)
        val selectedValue1: String = (textInputLayoutmenu1.editText as AutoCompleteTextView?)!!.text.toString()

        val textInputLayoutmenu2 = findViewById<TextInputLayout>(R.id.menu2)
        val selectedValue2: String = (textInputLayoutmenu2.editText as AutoCompleteTextView?)!!.text.toString()

        val stDate =findViewById<EditText>(R.id.startingDateText)
        val stDateText : String = stDate.text.toString()

        val estDate = findViewById<EditText>(R.id.estDateText)
        val estDateText : String = estDate.text.toString()
        //set up SharedPreferences
        val myPrefs: SharedPreferences = this.getSharedPreferences("prefID",MODE_PRIVATE)
        val editor: SharedPreferences.Editor = myPrefs.edit()
        editor.putString("taskName", taskName)
        editor.putString("projectName", selectedValue1)
        editor.putString("departmentName", selectedValue2)
        editor.putString("startingDate", stDateText)
        editor.putString("estdate", estDateText)
        editor.apply()

        Toast.makeText(applicationContext,"Saved",Toast.LENGTH_SHORT).show()
    }
}
