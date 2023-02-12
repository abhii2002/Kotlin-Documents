package com.blissvine.roomdemo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/*
 The dao interface is basically an interface that we need to create in our project that has the dao
 keyword annotated to it.

 The dao must be an interface and it  should be annotated with the dao keyword.

 */

//Inside the dao we define the functions in it to be used for querying the database.

@Dao
interface EmployeeDao {

/*
We need to make the @Insert a suspend function using the code routine because this is an operation which
will take some time and this must not be done on the main thread, it has to be done on the background thread
which is achievable by using the co routines
 */

    @Insert
    suspend fun insert(employeeEntity: EmployeeEntity) //This function will store an employee entity in our database.

    @Update
    suspend fun  update(employeeEntity: EmployeeEntity)

    @Delete
    suspend fun delete(employeeEntity: EmployeeEntity)

    @Query("SELECT * FROM `employee-table`")
    fun fetchAllEmployees(): Flow<List<EmployeeEntity>>

    @Query("SELECT * FROM `employee-table` where id=:id")
    fun fetchEmployeeById(id: Int):Flow<EmployeeEntity>

}