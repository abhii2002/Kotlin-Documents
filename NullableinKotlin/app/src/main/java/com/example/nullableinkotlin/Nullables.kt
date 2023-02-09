package com.example.nullableinkotlin

//  Nullables in Kotlin
// The idea of nullables  is just that its  a null type that allows
// to be a null type, so basically a type that allows variables to have a null as its value

fun main(){

   var name : String = "Milky"
//   name = null; // it does not accepts it as empty it has to have a value

    // we can not assign null as a value to variables , but it can be done by following way

  var nullableName : String? = "Milky" // here question mark allows to have a empty value
  //nullableName = null

 // Now to get length  of a variable name we cant directly use variablename.length for nullables
    // if we do so it will throw an error;

    var len = name.length // we can easily find length of normal a=variable using .length
    var len2 = nullableName?.length // but for nullables we have to use ? to get its length

    /* so what len2 will do is if it will be provided some value like in our  case milky has been provided
    then it will store it in len2 otherwise it will store a null value ,  if no value has been provided
    into nullableName
     */

     println("$len2") //  now we cant get null values by simply using println

    // we have to use methods in order to get or print null


   // nullableName?.let { print((it.length)) };

// ELVIS operator
    // Some times there is a condition where you want to assign a nullable to a non nullable variable
    // so it is done with the help of  elvis operator (?:)
 //  we use the  elvis operator in order to either  assign  value that is within that  nullable name variable
    // otherwise a default value that we provide eg..

     val name2 = nullableName ?: "Abhishek"
    //  so in this case either use  the value of nullableName  if its not null and if it is null
    // then use the default value "Abhishek"
    println("$name2");

 // Not Null Assertion operator(!!)


    // it is an operator that converts the nullable type to a non null type and throws a null pointer
  // exception if the nullable type holds a null value ,

    println(nullableName!!.lowercase())
    // it was example of  not null assertion operator , if the value of nullableName is null
    // it will throw and error of exception and if not then it will  print the value assigned in
    // nullableName , here lowercase is nothing but a method , it is just converting  alphabets
    // into lower letters


   // using safe call operator (?) in a chain
  // part of oops

  val wifesAge : String? = user?.wife?.age ?: 0

}