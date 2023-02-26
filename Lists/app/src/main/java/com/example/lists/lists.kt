package com.example.lists

/*
Lists can be used to hold both single data types and custom objects or classes they can be resized
to grow as new values are added.

They are mutable types which can be written to, and there are immutable types that you can not write
into but only read from.

 */

fun main(){
    val months = listOf("January", "February", "March")
    val anyTypes = listOf(1,2,3,true,false,"String")

    //To print the amount of items that we have in an item, we can use .size method
    print(anyTypes.size) // this will tell us there are 6 items in the list

    // Access items of a given list using the index.
    print(months[1]) // prints february

    // We can also use for loop to print all the elements of the list
    for (month in months){
        println(month)
    }

    /*
    These lists are immutable. so we can not add new items to them, for example we can not add any
    element in the months list by using any .add method

    But in order to make a list mutable, we can convert our existing list into a mutable list and then
    add items.
     */

    //Example
    val additionalMonths = months.toMutableList() // So this additionalMonths is going to be a list
    // a mutable list where we can add new items to it.
    val newMonths = arrayOf("April", "May", "June")
    // Now we can combine newMonths to additionalMonths
    additionalMonths.addAll(newMonths)
    //If you don't want to addAll items but some specific items then you can use this following approach
    additionalMonths.add("September")
    print(additionalMonths)

    //Creating a mutable list of a particular type.
    /*
    Now if you want to create a mutable list of a particular type, you can use this approach  by using
    the mutableListOf and then defining the type within <>

     */

     val days = mutableListOf<String>("Mon", "Tues", "Wed")
     //Since it is a mutable list we can add more elements
      days.add("Thurs")

    //Override items in a List -  To override an item in a list simply use the index approach
    days[2] = "Sunday"

    // Removing items in a List - To remove an item from a List, we can use remove method
    days.removeAt(3) // It will remove the item at index 3

    //Removing all items in the list
    days.removeAll(days) // will print an empty list, it will delete the whole list.

    //Removing all items with filtration.
    /*

    With this approach whatever items will be in the removeAll method will be removed from the list.
    In order to do that first we need to create a new variable that will contain the elements of the
    list that are needed to remove from the main list.

     */

    val removeList = mutableListOf<String>("Mon", "Wed")
    days.removeAll(removeList) // Filters and Removes Mon and Wed from days list

    print(days)
}