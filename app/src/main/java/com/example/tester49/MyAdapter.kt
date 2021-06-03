package com.example.tester49

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MyAdapter(private val mContext: Context, resource: Int, objects: List<CategoryModel>) :
    ArrayAdapter<CategoryModel?>(mContext, resource, objects) {
    private val listState: ArrayList<CategoryModel>
    private val myAdapter: MyAdapter
    private var isFromView = false
    override fun getDropDownView(
        position: Int, convertView: View,
        parent: ViewGroup
    ): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView!!, parent)
    }

    fun getCustomView(
        position: Int, convertView: View,
        parent: ViewGroup?
    ): View {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            val layoutInflator = LayoutInflater.from(mContext)
            convertView = layoutInflator.inflate(R.layout.dorpdown_checkbox_item, null)
            holder = ViewHolder()
            holder.mTextView = convertView.findViewById<View>(R.id.text) as TextView
            holder.mCheckBox = convertView.findViewById<View>(R.id.checkbox) as CheckBox
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        holder.mTextView!!.text = listState[position].getTitle()
        // To check weather checked event fire from getview() or user input
        isFromView = true
        holder.mCheckBox!!.isChecked = listState[position].isSelected()
        isFromView = false
        holder.mCheckBox!!.visibility = View.VISIBLE
        holder.mCheckBox!!.tag = position
        holder.mCheckBox!!.setOnCheckedChangeListener { buttonView, isChecked ->
            val getPosition = buttonView.tag as Int
            if (!isFromView) {
                listState[position].setSelected(isChecked)
                if(listState[0].isSelected()){
                    listState[position].setSelected(true)
                }
                Log.i("checkpos", "" + listState[position].getTitle())
                Log.i("valueif", "check$isFromView")
                Toast.makeText(context, "" + listState[position].isSelected(), Toast.LENGTH_LONG)
                    .show()
                if (listState[position].isSelected()) {
                    val sharedPreferences =
                        mContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString(listState[position].getTitle(), listState[position].getTitle())
                    editor.apply()
                } else {
                    val sharedPreferences =
                        mContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.remove(listState[position].getTitle())
                    editor.apply()
                }
            }
        }
        return convertView
    }

    private inner class ViewHolder {
        var mTextView: TextView? = null
        var mCheckBox: CheckBox? = null
    }

    init {
        listState = objects as ArrayList<CategoryModel>
        myAdapter = this
    }
}

