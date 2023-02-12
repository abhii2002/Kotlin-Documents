package com.blissvine.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Employee entity is also a model that we are using for our database
 */
@Entity(tableName =  "employee-table")
data class EmployeeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "",
    //this column info sets the name of the column to email-id internally
    @ColumnInfo(name = "email-id")
    val email: String = ""

/*
 If we don't override the name of a column with the @ColumnInfo, it will by default get the name that we
 gave to the property
 */


)
