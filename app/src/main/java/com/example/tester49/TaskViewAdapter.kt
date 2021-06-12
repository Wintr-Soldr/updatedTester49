package com.example.tester49

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskViewAdapter:RecyclerView.Adapter<TaskViewAdapter.ViewHolder>() {


    private val titles= arrayOf("Task Name 1","Task Name 2","Task Name 3")
    private val numpeople= arrayOf("5","5","6")
    private val startdates= arrayOf("21/12/2111","28/11/2590","11/11/1111")
    private val descc= arrayOf("This is desc\n..........\n..........","This is desc\n..........\n..........","This is desc\n..........\n..........")

    private val enddate= arrayOf("21/12/2121","28/11/2600","11/11/1110")




    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){


        var Tasktitle: TextView
        var Tasknumpeople: TextView
        var Taskstartdate:TextView

        var TaskEdit:TextView

        var Taskenddate:TextView

        init {
            Tasktitle=itemView.findViewById(R.id.TCV_PJ_Name)
            Tasknumpeople=itemView.findViewById(R.id.TCV_PJ_Number)
            Taskstartdate=itemView.findViewById(R.id.TCV_PJ_STARTDate)

            TaskEdit=itemView.findViewById(R.id.TEditthing)

            Taskenddate=itemView.findViewById(R.id.TCV_PJ_ESTDate)

        }




    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {



        val v= LayoutInflater.from(parent.context)
            .inflate(R.layout.task_view_model,parent,false)


        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Tasktitle.text=titles[position]
        holder.Tasknumpeople.text=numpeople[position]
        holder.Taskstartdate.text=startdates[position]

        holder.TaskEdit.setOnClickListener {
        //editing task
        }

        holder.Taskenddate.text=enddate[position]


    }

    override fun getItemCount(): Int {
        return titles.size
    }





}