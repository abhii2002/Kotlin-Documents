package com.blissvine.cameraimageselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.Manifest
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    var btnCamera: Button? = null
    var ivImage: ImageView? = null


    /*
    We use companion object constants when we want to use these variables multiple times throughout the
    application and its a good practise to store in companion object
     */
    companion object {

         const val CAMERA_PERMISSION_CODE = 1 //this code is for permission code
         const val CAMERA_REQUEST_CODE = 2  // this code is for the intent and activity for result


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCamera = findViewById(R.id.button)
        ivImage = findViewById(R.id.image)

        btnCamera?.setOnClickListener{
             if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                 ==  PackageManager.PERMISSION_GRANTED){
                 val  intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                 startActivityForResult(intent, CAMERA_REQUEST_CODE)
             }else{

                 ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_PERMISSION_CODE)

             }
        }

    }
    /*
    This  onRequestPermissionsResult method is used to execute something once we get a permissions result
    so either allowed it or denied it.
     */

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE){
             if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                 val  intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                 startActivityForResult(intent, CAMERA_REQUEST_CODE)
             }
        }else{
            Toast.makeText(this, "Oops you just denied the permission for camera." +
                    " You can allow it in the settings.", Toast.LENGTH_LONG).show()

        }
    }

    /*
    This function is automatically called once we get the result  for example, once the user selected
    an image with the camera.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
             if(requestCode == CAMERA_REQUEST_CODE){
                 //data can be of any type but here we want is as Bitmap
                  val thumbNail: Bitmap = data!!.extras!!.get("data") as Bitmap
                   ivImage?.setImageBitmap(thumbNail)
                 /*
                 So here we set the image view to be the thumbnail that we get from the data that was
                 passed to us from the onActivityResult
                  */
             }
        }
    }
}