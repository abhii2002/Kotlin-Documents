package com.example.typecasting

import java.lang.Math.floor

/*
We have a function main here and it is a typecasting file ins a list of strings.
 which we created a new variable called
String list and it i
 */
fun main(){
    // When you want to create a list, then you can use listof()
    val stringList: List<String> = listOf(
        "Abhishek", "Milky", "Aanchal", "Utkarsh")
    /* So this is a list which can only contain strings, but you can also create a list which has a
    mixed types for example, using the any keyword here we say that we accept any type of object in
   our list */
    val mixedTypeList: List<Any> = listOf(
        "Milky", 6, 9, "Bday", 50.5, "weighs", "kg")

    /*

     for(value in mixedTypeList){
        if (value is Int){
            println("Integer: '$value'")
        }else if(value is Double){
            println("Double: '$value' with Floor value ${floor(value)} ")
        }else if(value is String){
            println("String: '$value' of length ${value.length}")
        }else{
             println("Unknown Type")
        }
    }
*/
    //Alternate way  to check the conditions other than if and else statement
    // So what we have here is, a bunch of lambda expressions
    for(value in mixedTypeList){
         when(value){
              is Int -> println("Integer: $value")
             is Double -> println("Double: '$value' with Floor value ${floor(value)} ")
             is String ->  println("String: '$value' of length ${value.length}")
             else -> println("Unknown Type")

         }
    }

    // Smart Cast
    val obj1: Any = "I have a dream"
    if(obj1 !is String){
            println("Not a String")
    }else{
         // obj is automatically cast to a String in this Scope thats why we are able to use the .length property
        println("Found a String of length ${obj1.length}")
    }

    //Explicit (unsafe) Casting using the "as" keyword - can go wrong

    // it is a safe casting as the defined variable type and casting type are same
    val str1: String = obj1 as String
    println(str1.length)
    // this process only works fine when defined variable type is the same variable used with as followed by the type

    /* this is unsafe casting it can go wrong as the defined variable is of type double
    (val obj2: Any = 1224) and we are seeing it as a String (obj2 as String) */
    val obj2: Any = 1224
   //val str2: String = obj2 as String
   // println(str2)

    //Explicit (safe) casting using the "as?" keyword
    val obj3: Any = 1224
    val str3: String? = obj3 as? String
    println(str3) // Prints null
    // our str3 is nullable, so it can be null and when we are trying to cast we are not sure whether
    // it is gonna work or not


/*
In the for loop, we have value in mixed type list. So what we do is, we go through this mix type list
with this for loop and for every single value in that mixed type list, we want to run this if-else
BLOCK, So we check if the value is of type Integer or Double or String.
 */

}