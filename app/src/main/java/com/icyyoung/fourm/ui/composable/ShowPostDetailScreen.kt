package com.icyyoung.fourm.ui.composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.icyyoung.fourm.ui.viewModel.PostDetailViewModel

@Composable
fun ShowPostDetailScreen(viewModel: PostDetailViewModel) {
    val postDetailResponse by viewModel.postDetail.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    if (errorMessage != null) {
        Text(
            text = errorMessage!!,
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(16.dp)
        )
    } else {
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            postDetailResponse?.let { response ->
                Column(modifier = Modifier.padding(16.dp)) {
                    response.post.let { post ->
                        Text(
                            text = "帖子详情:",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        Text(text = "标题: ${post.title}")
                        Text(text = "作者: ${post.author}")
                        Text(text = "创建时间: ${post.created_at}")
                        Text(text = "内容: ${post.content}")
                        Text(text = "点赞数: ${post.like_nums}")
                        Text(text = "是否置顶: ${if (post.is_topped) "是" else "否"}")

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "评论列表:",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        response.comments.forEach { comment ->
                            Text(text = "ID: ${comment.id}, 内容: ${comment.content}, 作者: ${comment.author.name}, 点赞数: ${comment.like_nums}")
                            Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f), thickness = 1.dp)
                        }
                    } ?: run {
                        Text(text = "没有帖子信息.")
                    }
                }
            }
        }
    }
}