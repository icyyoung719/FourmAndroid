package com.icyyoung.fourm.data.model

//        fields = ['id', 'title', 'content', 'created_at', 'author', 'like_nums', 'is_topped']
data class Post(
    val id: Int,
    val title: String,
    val author: String,
    //    created_at = models.DateTimeField(auto_now_add=True)
    val created_at: String,
    val content: String,
    val like_nums: Int,
    val is_topped: Boolean
)
