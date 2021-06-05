package com.example.tester49

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){


    // Variables for scroll view cards
        private val projecttitles = arrayOf("Tracking Portal","tracking portal","track portal")//titles of project
        private val projectdesc= arrayOf("TextDes\nstatement 2","This is \n i dont know","Please read the below statment\nsure") //description of  project
        private val  projectnumppl= arrayOf("12","15","12")// number of people in project
        private val projectstartdate = arrayOf("21/12/2019","20/12/2500","20/12/2500") // start date of project
        private val projectnumtask = arrayOf("12 Tasks","25 Tasks","13 Tasks") // number of tasks in the projects please add tasks at the end of each elemet
        private val projectdeadline = arrayOf("22/12/2020","20/12/2600","20/12/2600") // project deadline






    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var PJTitle :TextView
        var PJDes : TextView
        var numpeople : TextView
        var stdate : TextView
        var numtask:TextView
        var deaddate:TextView
        var editlink:TextView


        init {
            numpeople=itemView.findViewById(R.id.CV_PJ_Number)

            PJTitle=itemView.findViewById(R.id.CV_PJ_Name)
            PJDes=itemView.findViewById(R.id.CV_PJ_desc)
            stdate=itemView.findViewById(R.id.CV_PJ_STARTDate)
            numtask=itemView.findViewById(R.id.CV_PJ_TaskNumber)
            deaddate=itemView.findViewById(R.id.CV_PJ_ESTDate)
            editlink=itemView.findViewById(R.id.Editthing)

        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {



        val v= LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_model,parent,false)

        return ViewHolder(v)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {



        holder.numpeople.text=projectnumppl[position]
        holder.PJTitle.text=projecttitles[position]
        holder.PJDes.text=projectdesc[position]
        holder.stdate.text=projectstartdate[position]
        holder.numtask.text=projectnumtask[position]
        holder.deaddate.text=projectdeadline[position]

        holder.editlink.setOnClickListener {

            // do the thing for edit here you have the position and other details njoy
        }




        holder.itemView.setOnClickListener { v:View ->

            Toast.makeText(v.context,"Clicked on ",Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return projecttitles.size
    }




}