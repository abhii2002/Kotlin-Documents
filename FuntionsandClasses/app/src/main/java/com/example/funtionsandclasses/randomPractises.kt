package com.example.funtionsandclasses

import android.print.PrinterInfo

fun main() {

      // write multiplication table of 2 using while loop

      var i = 1
      var k = 2

      while (i <= 10) {


            var result = i * k
            println("Multiplication table of 2 is : $result ")
            i++

      }

      print("while loop done its execution \n")

      // write multiplication table of 4 using for loop

      var a = 4
      for (K in 1..10) {

            var results = a * K
            println("$results ")

      }

      print("For loop done its execution \n")

      // write multiplication table of 6 using do while loop

      var m = 7
      var n = 0
      do {
            var resultOf6 = m * n
            println("$resultOf6 ")
            n++
      } while (n <= 10)


}





