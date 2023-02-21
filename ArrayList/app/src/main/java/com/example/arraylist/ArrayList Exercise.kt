package com.example.arraylist

/*
Please write a program that adds five Numbers (Double) to an arrayList and then
calculates the average of those numbers. Please use a for (in) loop in this exercise.
 */

fun main(){
      val numbersList : ArrayList<Double> = ArrayList<Double>()
      numbersList.add(44.37)
      numbersList.add(22.41)
      numbersList.add(27.95)
      numbersList.add(67.2)
      numbersList.add(23.90)

        var total = 0.0
    for (numbers in numbersList){

            total += numbers

    }
     var average = total / numbersList.size
    println("Average is $average")


}