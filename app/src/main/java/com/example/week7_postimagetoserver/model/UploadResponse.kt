package com.example.week7_postimagetoserver.model

data class UploadResponse(
    val message: String,
    val payload: Payload,
    val status: Int
)