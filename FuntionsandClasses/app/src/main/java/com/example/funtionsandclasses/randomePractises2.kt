package com.example.funtionsandclasses

// in this practise set we will utilize functions

fun main(){

     var result = addTwoNumber(4,5)
    println("The sum of 4 and 5 is $result")
   var mycar = cars("G3", "BMW", 120000)
     print(mycar)

}

fun  addTwoNumber(a: Int, b: Int) : Int{

             return a+b;
}

fun cars(model: String, Brand : String, Price : Int) : Any {

  println("Called from my cars function")

    return ("The model is $model  of Brand $Brand  and price is  $Price ")
}
