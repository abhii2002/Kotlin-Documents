package com.blissvine.recyclerviews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blissvine.recyclerviews.databinding.RecyclerviewItemBinding

/****
We need to create an adapter for our recycler view which will use our Task and TaskList as data source

 ****/


class MainAdapter(val taskList: List<Task>): RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    inner class MainViewHolder(val itemBinding: RecyclerviewItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){
              fun bindItem(task: Task){ // the data for the item should be gotten from the task
                    itemBinding.titleTv.text = task.title
                    itemBinding.timeTv.text = task.timeStamp
              }
        }


    /***
    What should happen once we create our view holder (or once our recyclerView is created).
     ***/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    /***
     What should happen once we bind the view holder
     */
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        // this makes sure every single item in taskList is able to connect to get data
        val task = taskList[position]
        //here we binding the task to our MainViewHolder
        holder.bindItem(task)
    }

    override fun getItemCount(): Int {
        /* here we are finding out what is the size and then we are displaying the amount of items that
         we want to display */
        return taskList.size
    }

}