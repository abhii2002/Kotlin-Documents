package com.example.interfaces

 // interfaces are a feature which allows us to extend the functionality of classes
/*
An interface may provide a default implementation of some or all of its properties and functions, but
it doesn't  have to , and if a property or function has a default implementation, the class that uses
this interface may choose to override it.
 */

interface Drivable{

       val maxSpeed : Double
       fun drive() : String // we have function header without any body
       fun brake(){ // we have a function with a body 
              println("The drivable is braking ")
       }
}


// Now if our class car decides to extend the functionality of the drivable interface then, it needs
// to implement the property that is created in the interface but is not implemented.

open class Car(override val maxSpeed: Double,
               val Name : String, val Brand : String) : Drivable{ // Step1: So here,  we need to go ahead and say
   // max speed of type Double should be in there
    /* Step2 :  And because we are overriding something, so we are overriding the max speed here, we need to
    add the keyword override
     */

    /* Step3 : But this by itself dosent makes our class happy, it is still complaining, and that is
    because we have not implemented the member called drive(). So this function drive() doesn't have a
    function body, we need to create one in the class that extends the interface(i.e class car)
     */

    open var range : Double = 0.0 // to override any property it should be set to open as well

    fun extendRange(amount : Double){

        if(amount > 0) {
            range += amount // we extended the range
        }
    }

    override fun drive(): String {
        return  "driving the interface drive"
    } // this drive comes from the interface that we are extending

    open  fun drive(distance : Double){
        println("Drove for $distance KM")
    } // It is the lowest level defined function in class car

    override fun brake(){
         super.brake() // this will be implemented for brake in drivable
        println("brake inside of electric car")// this will be implemented/run as well once brake function
                                              // is called
    }

    /* Step6: Our break had already an implementation, we never had to use it. But we can of-course use it
      we can use it in this subclass of car ( electric car). So you can override brake with the help
      of super keyword and that is to call the brake function of the superclass. And because our superclass
      which is our car didn't implement the functionality for brake hence, it will use the one from
      the interface.
     */

}

//Sub class or Child class or Derived class of Car
class ElectricCar (maxSpeed: Double, Name: String,Brand: String, BatteryLife : Double):
    Car(maxSpeed, Name, Brand){
    /* Step4: Now, if electric car wants to inherit from car  it also has to follow the structure of our Interface
       So we need to add maxSpeed */

    override  var range = BatteryLife * 5 // we over ridden range value

    override  fun drive(distance: Double){

        println("Drove for $distance Km on electricity")
    }

   /*
    fun  drive(){
        println("Drove for $range KM on electricity")
    }
    */

    /* Step5 : Now our function drive that we had in our electric car that we created dosent work anymore
    So it thinks that we are trying to ovveride the drive function which comes from
    override fun drive(): String {
        return  "driving the interface drive"
    }
    So here also we need to follow the structure of drive, hence we need to add override keyword and
    return the string type. Like below

     */

   override fun  drive() : String{
        return  "Drove for $range KM on electricity"
    }

}


fun main(){
    var audiA3 = Car(200.0,"A3" , "Audi") // we created object for class Car
    var teslaS = ElectricCar(240.0,"S-Model", "Tesla", 88.0) // and for class Electric car

    audiA3.drive(200.0)
    teslaS.drive(200.0)
    teslaS.extendRange(200.0) // we extended the range of our tesla using the extend function
    // so you can see even though electric car never implemented a function called drive but it can
    // still use it, as it inherits all of its features from its parent class
    teslaS.drive(); // here we called our function
}


/* So an interface is essentially a contract that a class may chose to sign if it does, the class is
obliged to provide the implementation of the properties and functions of the interface.

And we have seen that in our class car, as it is extending the interface drivable, its now obliged to
implement its variables, properties and functions.
For properties we did that using in the primary constructor and the function was implemented directly
in "driving interface drive"

Subclasses of a class that implement an interface, in this case our electric car, are also considered
to be implementing the interface.

So our electric car is also implementing the interface called drivable.
An interface can inherit from another interface.

Why to use interface ?
Interfaces are super useful when you have certain functions in mind that you definitely want to be
implemented later on. And also already know the properties of a class that you want to then have implemented
but you don't want to implement them directly.
You just want to prepare everything and you don't want to, for example create a specific body already  for
a function.

 */

