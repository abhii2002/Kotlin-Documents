package com.blissvine.recyclerviews


/****
 * RecyclerView requires an adapter to act as a data source and an Adapter requires a model
 * therefore here we created a data class (Task)
 *
 ****/
data class Task(val title: String, val timeStamp: String)