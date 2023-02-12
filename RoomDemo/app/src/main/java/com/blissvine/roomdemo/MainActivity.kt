package com.blissvine.roomdemo

import android.app.AlertDialog
import android.app.Dialog
import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.blissvine.roomdemo.databinding.ActivityMainBinding
import com.blissvine.roomdemo.databinding.DialogUpdateBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/*
 Room allows us to save data in a local database.
 It is a new way of storing data locally inside phone and it replaces the old fashioned way of storing data
 that was sql lite.
 So room is a jetpack library, which was created as a wrapper around sql lite.
 It makes it easy to write complex SQL statements to query the data you need without having to go through
 every single column.

 There are three components of Room Database:

 1. Entity -> Which is a data class that serves as the database table and will contain variables to build
        out a column, the class must be annotated with the add entity keyword and must have a variable
        that will serve as primary key, which is denoted by the annotation primary key.


2. Dao -> Dao stands for Data Access Object and is an interface that contains that necessary query to be
         performed for any of the operations required by the app. There are available convenient methods
         like add insert at fetch, at update, at delete and also a query you to write custom SQL statements
         and also note that you must annotate the interface with at Dao.

3. Database -> This class is annotated with  at database and extends the room database. It contains
               the database setup with the entity and serves as the main access point to the database
               access.

 */



class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding?  = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val employeeDao = (application as EmployeeApp).db.employeeDao()
        binding?.btnAdd?.setOnClickListener{
           addRecord(employeeDao)
        }

        //This have to be run in background because we are loading data so let us use coroutine
        lifecycleScope.launch{
             employeeDao.fetchAllEmployees().collect{
                    val arrayListOfEmployeeEntity = ArrayList(it)
                   setupListOfDataIntoRecyclerView(arrayListOfEmployeeEntity, employeeDao)

             }
        }



    }




    fun addRecord(employeeDao: EmployeeDao){
        val name = binding?.etName?.text.toString()
        val email = binding?.etEmail?.text.toString()

        if(name.isNotEmpty() && email.isNotEmpty()){
              lifecycleScope.launch {
                  employeeDao.insert(EmployeeEntity(name = name, email = email))
                  Toast.makeText(applicationContext, "Record saved",  Toast.LENGTH_SHORT).show()
                  binding?.etName?.text?.clear()
                  binding?.etEmail?.text?.clear()
              }
        }else{
             Toast.makeText(applicationContext, "Name or Email cannot be blank", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupListOfDataIntoRecyclerView(employeeList: ArrayList<EmployeeEntity>,
                                                employeeDao: EmployeeDao){

        if(employeeList.isNotEmpty()){
            val itemAdapter = ItemAdapter(employeeList,
                {
                updateId ->
                 updateRecord(updateId, employeeDao)
            })
                {
                    deleteId ->
                    lifecycleScope.launch{
                        employeeDao.fetchEmployeeById(deleteId).collect {
                             if(it != null) {

                                 deleteRecordAlertDialog(deleteId, employeeDao, it)
                             }
                        }
                    }

                }


            binding?.rvItemsList?.layoutManager = LinearLayoutManager(this)
            binding?.rvItemsList?.adapter = itemAdapter
            binding?.rvItemsList?.visibility = View.VISIBLE
            binding?.tvNoRecordsAvailable?.visibility = View.GONE

        }else{

            binding?.rvItemsList?.visibility = View.GONE
            binding?.tvNoRecordsAvailable?.visibility = View.VISIBLE
        }

    }



    private fun updateRecord(id:Int, employeeDao: EmployeeDao){
        val updateDialog = Dialog(this, R.style.Theme_Dialog )

        updateDialog.setCancelable(false)
        val binding = DialogUpdateBinding.inflate(layoutInflater)
        updateDialog.setContentView(binding.root)

         lifecycleScope.launch{
              employeeDao.fetchEmployeeById(id).collect{
                  if(it != null) {
                      binding.etUpdateName.setText(it.name)
                      binding.etUpdateEmail.setText(it.email)
                  }

              }
         }

        binding.tvUpdate.setOnClickListener{
             val name = binding.etUpdateName.text.toString()
            val email = binding.etUpdateEmail.text.toString()

            if(name.isNotEmpty() && email.isNotEmpty()){
                 lifecycleScope.launch{
                      employeeDao.update(EmployeeEntity(id, name, email))
                     Toast.makeText(application, "Record Updated.", Toast.LENGTH_SHORT).show()
                     updateDialog.dismiss()
                 }
            }else{
                Toast.makeText(applicationContext, "Name or Email cannot be blank", Toast.LENGTH_SHORT).show()
            }

        }

        binding.tvCancel.setOnClickListener{
             updateDialog.dismiss()
        }
        updateDialog.show()


    }

    private fun deleteRecordAlertDialog(id:Int, employeeDao: EmployeeDao, employee: EmployeeEntity){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Delete Record")
        builder.setIcon(android
            .R.drawable.ic_dialog_alert)
        //set message for alert dialog
        builder.setMessage("Are you sure you wants to delete ${employee.name}.")
        builder.setIcon(android.R.drawable.ic_dialog_alert)

        //performing positive action
        builder.setPositiveButton("Yes"){ dialogInterface, _ ->
            lifecycleScope.launch{
                 employeeDao.delete(EmployeeEntity(id))
                Toast.makeText(
                    applicationContext,
                    "Record deleted successfully.",
                    Toast.LENGTH_LONG
                ).show()

            }
            dialogInterface.dismiss()
        }

        //performing negative action
        builder.setNegativeButton("No") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()

    }

}