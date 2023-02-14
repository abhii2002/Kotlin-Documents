package com.example.funtionsandclasses

// in this practise set we will practise on objects and classes

fun main(){

 var  myStoreObject = Store("Perry-Perry" , "California", 120000)
     println("The timing of the restaurant is ${myStoreObject.RestaurantTiming}")
     myStoreObject.MenuItems = "Pizza,Burger,Noodles, Coldrink"
    myStoreObject.Menu();
}


class Store(Name : String , Location : String , Price : Int, TopDessert : String = "Ice-Cream" ){

     var RestaurantTiming : String = "7:00 AM TO 6:00 PM"
     var  MenuItems : String? = null
     var  TopDessert : String? = null

    init {

         this.TopDessert = TopDessert // null variable assigned to parameter variable
        println("The Name of the restaurant is $Name at Location $Location with price of $Price " +
                " \n With Top dessert $TopDessert"
        )

    }

    fun Menu(){

        println("The menu  of the Restaurant is $MenuItems")
    }

}



