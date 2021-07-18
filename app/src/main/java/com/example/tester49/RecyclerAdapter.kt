package com.example.tester49

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//adapter
class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

// variables
    private val names = arrayOf("Abhishek", "Rekha", "Rahul")//names of handlers 
    private val identities = arrayOf("id: M1011", "id: M1010", "id: M1009")//id nos of handlers
    private val tasksDone = arrayOf(
        "Updated Task 1",
        "Scheduled Meeting with CMS Team",
        "Any update in task or new task"
    )//task status 
    private val assignedTo =
        arrayOf("Assigned Task to Rohan", "Assigned Task to Shweta", "Assigned Task to XX")//assignees
    private val teams = arrayOf("Team : Social Media", "Team : UI UX Website", "Team : XX")//team name

//creating and assigning values to view
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemName: TextView
        var itemId: TextView
        var itemTask: TextView
        var itemAssign: TextView
        var itemTeam: TextView

        init {
            itemName = itemView.findViewById(R.id.name)
            itemId = itemView.findViewById(R.id.identity)
            itemTask = itemView.findViewById(R.id.task_done)
            itemAssign = itemView.findViewById(R.id.assignee)
            itemTeam = itemView.findViewById(R.id.team)
        }
    }
//inflating the view
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view, viewGroup, false)
        return ViewHolder(v)
    }
//assigning values to elements
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemName.text = names[i]
        viewHolder.itemId.text = identities[i]
        viewHolder.itemTask.text = tasksDone[i]
        viewHolder.itemAssign.text = assignedTo[i]
        viewHolder.itemTeam.text = teams[i]
    }

    override fun getItemCount(): Int {
        return names.size
    }
}
