package com.example.arrays

// Arrays allows to store multiple pieces of data in one variable.

fun main(){

    // First way
       //val numbers:IntArray = intArrayOf(1,2,3,4,5,6)
    // we created variable number of type IntArray and then we are using a method called intArrayOf()
    // where we can then assign values, i.e multiple integer values

    //  val numbers = intArrayOf(1,2,3,4,5,6)
    /*
    We don't need to specifically say that its  going to be of type int since we are using intArrayOf,
    numbers variable knows that it should be an array of integers.
     */

    // Third way - More simpler way of writing the above code
    val numbers = arrayOf(1,2,3,4,5,6)

   /* print(numbers) This will not work for arrays, it will just print the address of the array which
   where it is stored in memory. This is because we can not just print a race with the print method */

    /* In order to print arrays, we need to use utility method provided in Kotlin for that purpose.So we
    will need to use a method called contentToString. So it just converts the content of array into a
    String */

    print("Initial values: ${numbers.contentToString()}")

    //Printing items of array individually

    for (element in numbers){
           print(element)
    }

    /*
    We used the for loop which is one of the simplest way to iterate through each element of the array
     Here, element is variable so for element in numbers print numbers. So what is happening now is
     that it goes through this numbers array and for every single item, starting from the first, it
     will store that in element in the first iteration and the second iteration it will store the two
     in element and so forth.

     So its going to go through all the numbers inside of this number array and we will store them in
     element variable and then print them out
     */

    // we can even modify our variable in  array
    for (element in numbers){
        print("\n${element+2}\n")
    }

    /* Accessing the particular element in an array. For example to access the element at index zero
    we need to use square brackets followed by the position of the element in array */

      println(numbers[0]) // prints 1

    // Modifying arrays - For example store different value at position zero
    numbers[0] = 13
    numbers[1] = 55
    numbers[2] = 34
    numbers[3] = 78
   //  numbers[7] = 78 // this is invalid, it will throw out of bond exception as arrays have a
    //  fixed size, we can not increase the size or try to add a new
    //index since we have six values and index starts from 0 to 5.
    print("\nChanged values: ${numbers.contentToString()}")

  // DoubleArrays

    val numbersD : DoubleArray = doubleArrayOf(2.3,4.5,1.0,3.0,7.3,9.0)

    //modifying elements, indexes
    numbersD[0] = 3.2
    numbersD[4] = 6.4
    numbersD[5] = 7.3

    println("Double arrays are : ${numbersD.contentToString()}")

    val days = arrayOf("Sun", "Mon", "Tues", "Wed", "Thurs", "Fri", "Sat")
    print(days.contentToString())

    // creating object of class fruit - here we can just create a fruit list, which will be an array
    //Of different fruits. So we can create fruit objects

    val fruits = arrayOf(Fruit("Apple", 2.5), Fruit("Grape", 4.5))
    println(fruits.contentToString())

    for(fruit in fruits){
        print(" ${fruit.name}")
    }

    for(index in fruits.indices){
        print("${fruits[index].name} is in index $index")
    }

    //Array with multiple different data types
      val mix = arrayOf("Sun", "Mon", "Tues", 1,2,3, Fruit("Mango", 2.4))
    print(mix.contentToString())

}

// We can even store entire objects inside of an array

 data class Fruit(val name: String, val price: Double)