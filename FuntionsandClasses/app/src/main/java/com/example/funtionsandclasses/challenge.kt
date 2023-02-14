package com.example.funtionsandclasses

/* Please extend our example of the MobilePhone class with

class MobilePhone(osName: String, brand: String, model: String){
    init {
        println("The phone $model from $brand uses $osName as its Operating System")
    }
}
Add a member to it, which indicates how much battery is left (call it "battery". Initialize this
value with a number between 0 and 50.
Then add a function "chargeBattery" Which needs details about how much was charged.

It should print out how much battery the phone had before, how much was charged and how much it has now.
Create an Object of the class and call this function. Charge the battery by 30.

 // we can solve it many ways , the two different ways are as  follows


 */
/* var  battery = 30
fun main(){

    var Samsung = MobilePhones("KitKat", "Samsung", "A30" )
    chargeBattery(20)
}


class MobilePhones(osName: String, brand: String, model: String){


    init {
        println("The phone $model from $brand uses $osName as its Operating System")

    }

}

fun chargeBattery(ChargedBy : Int){

    battery =  battery + ChargedBy;
    println("Battery was at $battery and  is at ${battery+ChargedBy}")

} */

fun main(){
    val iphone = MobilePhones("iOS", "Apple", "iPhone 12")
    val galaxyS20 = MobilePhones("Android","Samsung", "Galaxy S20")
    val mateXS = MobilePhones("Android", "Huawei", "Mate X S")
    iphone.chargeBattery(40);
}

class MobilePhones(osName: String, brand: String, model: String){

    private var battery = 30

    init {
        println("The phone $model from $brand uses $osName as its Operating System")
    }

    fun chargeBattery(chargedBy: Int){
        println("Battery was at $battery and is at ${battery+chargedBy} now")
        battery += chargedBy
    }
}