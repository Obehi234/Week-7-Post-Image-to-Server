package com.example.week7_postimagetoserver

import com.example.week7_postimagetoserver.model.UploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {

    @Multipart
    @POST("api/v1/upload")
    suspend fun uploadImage(@Part image: MultipartBody.Part, @Body body: RequestBody): UploadResponse
}