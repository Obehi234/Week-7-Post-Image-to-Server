package com.example.week7_postimagetoserver.model

data class Payload(
    val downloadUri: String,
    val fileId: String,
    val fileName: String,
    val fileType: String,
    val uploadStatus: Boolean
)