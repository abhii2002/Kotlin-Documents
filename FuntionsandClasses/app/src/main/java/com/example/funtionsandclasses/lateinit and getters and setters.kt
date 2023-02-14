package com.example.funtionsandclasses

import java.lang.IllegalArgumentException

// Lateinit and Getters and Setters

fun main(){
   var mycar = car();

    println("brand is : ${mycar.myBrand}")
    mycar.maxspeed = 20
    println("Max speed is ${mycar.maxspeed}")
 //   mycar.myModel = "m2" // it wont work as we set the setter private
    println("The model is ${mycar.myModel}") // it will work as we didn't set getter as private like setter
}

class car(){
// after creating a variable in a class  it is mandatory to initialize it
    // so to get rid of error we can use the lateinit , which means we will initialize our variable later on
      lateinit var  owner : String
      val myBrand : String = "BMW"
        get(){
             return  field.lowercase()

        }

    /* whenever we create a variable in a class a custom getter and setter is automatically created in
    background for us and we dont need to create it
   it  is some what like this: */

    var maxspeed : Int = 250
        get() =  field
        set(value) {
            field = if(value > 0) value else throw IllegalArgumentException("Max speed can not be less than zero")
        }  // so we specifically typed it and made some changes according to our need
  /*  so this code is already generated for us we dont need to type it specifically after declraing the
    variable but what we can do is if we want to edit it by own requirements then we may type it
    specifically
    */

    // private Setter
      var myModel : String = "M5 "
           private set
/* private set says something is only available within  the same class so, in this case it will be
only be available within the class car and if we  try to assign values to it inside our main function
it wont work , however we just used setter s but not getter so we can still access this variable outside
this class, therefore if we try to print mymodel it will work , it wont throw any error
 */

       init {

            this.owner = "Abhishek"
            this.myModel = "M3" // it will work  because we set the setter private but it is within
                               // class , and private itself means it will work within the class
       }





}