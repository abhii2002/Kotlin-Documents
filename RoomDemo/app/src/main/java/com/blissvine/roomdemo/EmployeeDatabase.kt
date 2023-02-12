package com.blissvine.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/*
This will be an abstract class that inherits from the room database class.
 */

/*****
 *
 Here for this  database class, we need to define some additional information about this database so
 we need to define the version and entities that we want to use

 ****/

/*
Here we defining the version name as 1 because it is our first database and later if we make any update to
this database, for example we change the amount of properties that we have in a table then we have to change
the version.
 */

@Database(entities = [EmployeeEntity::class], version = 1)
abstract class EmployeeDatabase: RoomDatabase() {

    // now here we need to connect our database to dao

    abstract fun employeeDao(): EmployeeDao
    //we need to define a companion object which allows us to add functions on the employee database class
    companion object {
          @Volatile
          private var INSTANCE: EmployeeDatabase? = null

        //Helper function to get database (so if a database has already been retrieved, the previous
        // database will be returned. otherwise we are going to create a new database.

         fun getInstance(context: Context): EmployeeDatabase{
              synchronized(this){
                   var instance = INSTANCE

                  if(instance == null){
                       instance = Room.databaseBuilder(
                           context.applicationContext,
                           EmployeeDatabase::class.java,
                           "employee_database"
                       ).fallbackToDestructiveMigration().build()

                      INSTANCE = instance
                  }
                  return instance
              }
         }

    }

}