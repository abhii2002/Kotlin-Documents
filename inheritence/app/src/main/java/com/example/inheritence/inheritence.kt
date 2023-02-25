package com.example.inheritence


// Inheritance allows a class to inherit  features such as properties and methods from another class
// and reduce them

// The class that inherits the feature of another class is called the Sub class or Child class
// or Derived  class, and the class whose features are inherited is called the super class or Parent
// class or Base class


// we created a class  whose properties and methods will be inherited in other class, but make sure
// to make this class open , otherwise we wont be able to use inheritance, as by default
// in kotlin are classes are set to closed

// Super Class, Parent Class, Base Class of Vehicle
open class Car(val Name : String , val Brand : String){  // after car keyword everything in brackets is primary constructor which may
    // contains some values
    // suppose it have properties
    // suppose it have methods
    open var range : Double = 0.0 // to override any property it should be set to open as well

    fun extendRange(amount : Double){

        if(amount > 0) {
            range += amount // we extended the range
        }
    }

   open  fun drive(distance : Double){
        println("Drove for $distance KM")
    }


}

// Sub Class , Child Class or Derived Class of Car
// we created another class and specified that it inherits from vehicle class
// We need to use same parameters that were used for the car, for your electric car as well
class ElectricCar (Name: String,Brand: String, BatteryLife : Double):  Car(Name, Brand){
// it has to have at least the features of the class that it inherits from, but it can extend features
// for example we extended a feature batteryLife

    override  var range = BatteryLife * 5 // we over ridden range value

    override  fun drive(distance: Double){

         println("Drove for $distance Km on electricity")
    }

    fun  drive(){

        println("Drove for $range KM on electricity")

    }
}

// Any Class inherits from the any class

fun main(){
    var audiA3 = Car("A3" , "Audi") // we created object for class Car
    var teslaS = ElectricCar("S-Model", "Tesla", 88.0) // and for class Electric car

    audiA3.drive(200.0)
    teslaS.drive(200.0)
    teslaS.extendRange(200.0) // we extended the range of our tesla using the extend function
    // so you can see even though electric car never implemented a function called drive but it can
    // still use it, as it inherits all of its features from its parent class
     teslaS.drive(); // here we called our function
}


