package com.example.funtionsandclasses

import java.time.Period

fun main(){

    // creating  objects of classes
    var Abhishek  = person("Abhishek", "Singh", 31) // so we have a object  of class person
 // variable of  a type person , like int is a type float is type , likewise we created a type person
    // with the help of class , so by creating a class we created our own type
    var John = person(); // so we can print the default values given in our class below
     var JohnSingh = person(LastName = "Singh");
    Abhishek.statehobby(); // it will print the hobby , but it is same for all
    Abhishek.hobby = "To Skateboard"; // we specifically assigned a hobby
    John.hobby = "Play Video Games";
    Abhishek.age =  32;
    println("Abhishek is ${Abhishek.age} years old")
    John.statehobby(); // will print hobby of john
}

// we can create our own classes in kotlin and set specific  properties and methods on them
/* Take a example of car where Properties like colour of car, number of tiers, doors, are the properties
 and the skills or methods like braking system , driving , so in a class The properties can be variables
 and skills could  be methods
 */

// Defining a class
// We created a class named person and passed two parameters  in it
// we can even assign default values here like john Doe
class person(Name : String = "john ",  LastName : String = "Doe"){

      // Member variables( a member variable is variable within in a class) - properties
    var age : Int? = null;
    var hobby : String =  "Watch netflix";
    var Name: String? = null;

    // whenever we create a class, we can also have an init there , this is a
    // initializer which is called once an object is created
    //  initializer block
    init{

        this.Name = Name;
        println("Initialized a new Person object  With "
                + "firstName = $Name and Lastname = $LastName and $age " );

    }

// we can use initializer init in order to initialize your object, which means prepare your object
// its like us creating variables  here when we use them in our constructor type
    // as $name and and $lastname  gives us value

    // Member Secondary Constructor

    // the name and last name should be coming from our primary constructor person
    constructor(Name: String, LastName: String, age: Int)
            : this(Name, LastName) {
        this.age = age; // this.age is the member variable we declared in class person and age is the integer
        // that will be passed in secondary constructor and it will be assigned to this.age
    }

    // Member functions (also called Methods) - A member function is a function within a class as a
    //  member

    fun statehobby(){

         println("$Name\'s hobby is $hobby");
    }


 }