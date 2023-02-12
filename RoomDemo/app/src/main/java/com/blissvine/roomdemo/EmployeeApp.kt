package com.blissvine.roomdemo

import android.app.Application

/*
For every application class, we must declare the app that we have setup here  in the android manifest
 */
class EmployeeApp : Application(){
    val db by lazy{
         EmployeeDatabase.getInstance(this)
    }
}