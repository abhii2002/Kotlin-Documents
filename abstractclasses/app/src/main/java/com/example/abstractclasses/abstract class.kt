package com.example.abstractclasses

import java.util.function.DoublePredicate

/*
Abstract classes are a little bit similar to interfaces, but they are still different.
An abstract can not be instantiated. That is the same for interfaces, you can not create an object
of an interface.
However, you can inherit subclasses from an abstract class and the members, So properties in the
methods of an abstract class are non abstract unless, you explicitly use the abstract keyword to make
them abstract
 */

// Let us look at an example here,

abstract class Mammal(private val name : String, private val origin: String,
      private val weight: Double){ //  Concrete (Non Abstract) Properties
// So the three variables here name, origin, and weight that we created, they are non abstract.

   // Abstract property (Must be overridden by Subclasses)
    abstract  var maxSpeed: Double
  /* This property here maxSpeed is abstract, s o its must be overridden by its subclass. So if a class
     inherits from Mammal, then it will need to implement those, to override those. */

    //Abstract Methods (Must be implemented by Subclasses)
    // methods without body
    abstract fun run()
    abstract fun breathe()

 //  Concrete (Non Abstract) Method
    fun displayDetails(){
          println("Name: $name, Origin: $origin, Weight: $weight, Max Speed: $maxSpeed")
    }
    /*
     We can also create non abstract methods in such an abstract class. So we are not limited to
     abstract methods.
     We can also create methods such as display details that we have here, which will display just
     the name, origin and speed of the mammal that we are creating
     */
}

class Human(name: String, origin: String, weight: Double,
override  var maxSpeed: Double) : Mammal(name, origin, weight){

    override fun run(){
        println("Runs on two legs")
    }

    override fun breathe(){
            println("Breathe through mouth and nose")
    }

    /*
    We created a human class, that inherits from Mammal.So here we must override all the methods and
     property such as run() and breathe()
     */

}

class Elephant(name: String, origin: String, weight: Double,
            override  var maxSpeed: Double) : Mammal(name, origin, weight){

    override fun run(){
        println("Runs on four legs")
    }

    override fun breathe(){
        println("Breathe through the trunk")
    }

    /*
    we can add a bunch of more functions and a bunch of more properties.
     */

}

fun main(){
    val human =  Human("Abhishek", "India", 55.0, 20.0)
    val elephant = Elephant("Rosy", "Australia", 54000.0, 25.0)

    human.run()
    elephant.run()

    human.breathe()
    elephant.breathe()

   // val mammal = Mammal("Milky","India", 70.0, 28.0)
    /*
    we can not create an instance of an abstract class. You can however, of course, do that with the
    classes that inherited from it such as our human and elephant, which are both classes that inherit
    from our abstract class called Mammal
    */


}


/*

So what is the difference between an abstract class and an interface ?

An interface can not hold state and we can implement multiple interfaces, but only one class. So we can
implement multiple interfaces, we are not limited to just one interface, but we can only inherit from
one class.

Also classes have constructors, So even an abstract class has a constructor.
But an interface doesn't have a constructor here and interfaces can not hold fields.

So basically abstract classes can have everything that interfaces can add. Additionally they can have
fields and constructors. Therefore we can properly hold state in abstract class.

 */

