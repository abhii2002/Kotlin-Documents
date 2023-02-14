package com.example.funtionsandclasses

// Exercise on classes and objects
/* Please create a class called MobilePhone. It should have three primary constructor variables,
osName, brand and model. Use the initializer to print those details.Create three objects of that
class in the Main function.
Examples of phones would be:
Samsung Galaxy S20 Ultra. Here the osName is Android, brand is Samsung, model is Galaxy S20 Ultra */

fun main(){

    var MyObject = MobilePhone("Android",  "Samsung", "S20 Ultra");
}

class MobilePhone(OSname : String, Brand : String, Model : String){

    // Member variables (member variables are the variables within a class

    var osFunction = "To Boot The Android"
    var osBattery = 34
    var osName : String? = null

     init{
            println("The Os name is $OSname, Brand is $Brand and Model is $Model ");
     }



}