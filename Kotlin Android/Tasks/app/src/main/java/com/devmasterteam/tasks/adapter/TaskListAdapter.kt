package com.devmasterteam.tasks.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.devmasterteam.tasks.viewholder.TaskViewHolder
import com.devmasterteam.tasks.entities.TaskEntity
import com.devmasterteam.tasks.entities.listener.OnTaskListFragmentInteractionListener
import android.view.LayoutInflater
import com.devmasterteam.tasks.R

class TaskListAdapter (private val taskList: List<TaskEntity>, private val listener: OnTaskListFragmentInteractionListener) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        // Obtém item da lista
        val task: TaskEntity = taskList[position]
        holder.bindData(task, listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val context = parent.context

        // Infla o layout da linha e faz uso na listagem
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_task_list, parent, false)

        return TaskViewHolder(view, context)
    }
}