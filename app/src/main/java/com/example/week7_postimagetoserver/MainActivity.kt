package com.example.week7_postimagetoserver

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService
    //private lateinit var imgView: ImageView
    private lateinit var btnUpload: Button
    //private var imageUri: Uri? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        setup()
    }

    private fun setup() {
        val imgView: ImageView = findViewById(R.id.imgView)
        imgView.setOnClickListener { openGallery() }
        btnUpload = findViewById(R.id.btnUpload)
        btnUpload.setOnClickListener { uploadImage() }
    }

    private fun openGallery() {
        val imgView : ImageView = findViewById(R.id.imgView)
        val contract = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            uri?.let {
               // imageUri = it
                imgView.setImageURI(it)
            }
        }
        contract.launch("image/*")
    }


    private fun uploadImage() {
//        imageUri?.let { uri ->
//            val inputStream = contentResolver.openInputStream(uri)
//            val file = File(cacheDir, contentResolver.getType(uri))
//            val outputStream = FileOutputStream(file)
//            inputStream?.use { input ->
//                outputStream.use { output ->
//                    input.copyTo(output)
//                }
//            }
//
//            val requestBody = RequestBody.create("image/*".toMediaTypeOrNull(), file)
//            val imagePart = MultipartBody.Part.createFormData("image", file.name, requestBody)
//            val jsonMediaType = "application/json".toMediaTypeOrNull()
//            val requestBodyJson = RequestBody.create(jsonMediaType, "{}")
//
//            CoroutineScope(Dispatchers.IO).launch {
//                try {
//                    val response = apiService.uploadImage(imagePart, requestBodyJson)
//                    Log.d("IMAGE UPLOADER", response.toString())
//                } catch (e: Exception) {
//                    Log.e("IMAGE UPLOADER", "Error uploading image", e)
//                }
//            }
//        } ?: run {
//            Toast.makeText(this, "Select an image first", Toast.LENGTH_SHORT).show()
//        }
    }
}
