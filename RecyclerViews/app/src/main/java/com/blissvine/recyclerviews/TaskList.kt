package com.blissvine.recyclerviews


/****
This is our data source, (data can be accessed from room database or api etc..) but for the simplicity
we are just creating a list of a bunch of items
 ****/
object TaskList {

    val taskList = listOf<Task>(
        Task("Take a Walk", timeStamp = "7:00 am"),
        Task("Eat BreakFast", timeStamp = "8:00 am"),
        Task("Attend a Meeting", timeStamp = "9:00 am"),
        Task("Read a Book", timeStamp = "12:00 pm"),
        Task("Eat Lunch", timeStamp = "2:00 pm"),
        Task("Buy Groceries", timeStamp = "4:00 pm"),
        Task("Watch Youtube Videos", timeStamp = "6:00 am"),
        Task("Eat Dinner", timeStamp = "7:00 am"),
        Task("Go to Bed", timeStamp = "9:00 pm")
    )


}