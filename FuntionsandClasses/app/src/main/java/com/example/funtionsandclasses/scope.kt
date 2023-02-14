package com.example.funtionsandclasses

 var  b = 5 // now we can access any variable in any function because we created this variable globally
// now we will be able to access all the variables b in main function or myfunction
fun main(){

      myFunction(5); // here we can pass arguments , it is valid
      // b =3 // so we can not access this variable b which was created in myFunction because it is
    // outside of its scope
    var b = 3 // now this variable b is not the same as the variable b declared below in myFunction


}

fun myFunction(a : Int){
      // a = 5; //  we can not assign value to a here as it is  not a variable there , it is parameter
    // var a = 4; // this variable is different from the parameter a
    var a = a; // now the value of a that was in parameter will be assigned to our variable a here
    var  b = a; // now we created another variable just to how that we can not access this variable
        // out of its scope i.e if we try to use this variable outside our myfunction it wont work at all
       // here we created it so we can use it here only
}
