package com.example.funtionsandclasses

data class User(val id : Long,  var name: String)

fun main(){

     val  user1 = User(1, "Abhishek")

     //val name = user1.name
   //  println(name)
    user1.name = "Aditya"
    var user2 = User(1, "Aditya")

    println(user1 ==  user2) // compare user1 and user 2

   println("User Details : $user1")

    // Copy one  object to another

// val updatedUser = user1.copy() // so it will copy all details of user 1 and will assign it to updatedUser
    val updatedUser = user1.copy(name = "Utkarsh Chouhan") // it will also do the same thing except this time
    // while copying we changed the name value
    println(updatedUser)

    // we can also  get components of the variable we created i.e  updateduser

    println(updatedUser.component1()) // will print the value of id that is  1
    println(updatedUser.component2()) // prints the name we updated that is Utkarsh Chouhan

    // DECONSTRUCTION -  another feature

    val (id, name) = updatedUser // so we are making these two variables dependent in updatedUser
    // so what it will do is now it will take the id and name from the updatedUser and its going
    // to store them in separate variables
    println("id = $id, name= $name ") // now we can use this functionality to  get id and name

}
