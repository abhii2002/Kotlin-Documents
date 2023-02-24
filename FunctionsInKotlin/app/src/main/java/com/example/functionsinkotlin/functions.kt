package com.example.functionsinkotlin

// functions are the important part of any programming language

fun main(){
    /* main is our main function as it is the entry point of our program
     within main we can call our  other functions that we made to get desired outputs */
     myFunction(); // here we called our myFunction inside our main function

    // Before calling a function with parameters we should store the function in a variable

    // calling the add up function

    var result = addUp(5 , 4); // 5 and 4 are the arguments passed
    /* we created a variable to store the addUp function and then we passed the arguments for the
     parameters we declared in addUp function
    in our addUp function */
    print(result);

    var avgResult = Average(1.0f,2.0f);
    println("\n Average of 1 and 2 is $avgResult");


}

// within rounded brackets we add the parameters
fun myFunction(){  // so we created a function named myFunction

    /* within curly brackets you can add to code blocks that should be executed once this function
    is called */

    print("Called from myFunction");
}

// creating another function

           // we passed two parameters a and b as type Int
fun addUp(a : Int, b: Int) : Int {

    /* The third int after parameters is to specify data type of our result It says return
     a result whose datatype should be Int */

       return a+b;  // we used our parameters to return a value we wanted to accomplish on parameters
}


// There is another thing in concept of functions and it  is called  Method
// METHOD :- a Method is a function within a class

// CHALLENGE :-> Write a function which will build the average of two values

fun Average(x: Float, y: Float) : Float{

     return (x+y)/2;
}


// functions provides functionality
// functions can be used for various thing
// they are pre-baked pieces  of code and can be later on used anytime by anyone
// functions can be reused
// you can make a function the way you want and then re use according to your needs
