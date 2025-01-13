package com.icyyoung.fourm.data.model

//class CommentSerializer(serializers.ModelSerializer):
//class Meta:
//    model = Comment
//fields = ['id', 'content', 'created_at', 'author', 'post', 'like_nums']
//read_only_fields = ['created_at', 'author', 'post']
data class Comment (
    val id: Int,
    val content: String,
    val createdAt: String,
    val author: User,
    val post: Post,
    val likeNums: Int
)