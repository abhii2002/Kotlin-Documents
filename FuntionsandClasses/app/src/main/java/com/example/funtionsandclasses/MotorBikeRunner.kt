package com.example.funtionsandclasses


    fun main() {

        var honda = MotorBike();
        var BMW = MotorBike();

        honda.start();
        BMW.start();

        // Setting values for Member Variables
        honda.speed = 20;
        BMW.speed = 70;

        println(honda.speed);
        println(BMW.speed);

    }

