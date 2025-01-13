package com.icyyoung.fourm.data.model

//        fields = ['id', 'name', 'email' , 'created_at', 'bio']
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val createdAt: String,
    val bio: String,
)