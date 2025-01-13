package com.icyyoung.fourm

import android.annotation.SuppressLint
import android.net.http.HttpException
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import timber.log.Timber // 如果你使用 Timber 进行日志记录
import com.icyyoung.fourm.data.api.ApiConfig
import com.icyyoung.fourm.data.model.PostDetailResponse

class MainActivity : ComponentActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (true) { // 初始化 Timber, 恒为 True
            Timber.plant(Timber.DebugTree())
        }

        setContent {
            var postDetailResponse by remember { mutableStateOf<PostDetailResponse?>(null) }
            var errorMessage by remember { mutableStateOf<String?>(null) }

            LaunchedEffect(key1 = Unit) {
                lifecycleScope.launch {
                    try {
                        val response = ApiConfig.apiService.getPostDetail(3)
                        postDetailResponse = response
                        Timber.d("API Response Body: $response")
                    } catch (e: Exception) {
                        errorMessage = when (e) {
                            is HttpException -> "HTTP 错误: ${e.message}"
                            else -> "无法加载数据，请检查网络连接"
                        }
                        Timber.e(e, "Error fetching post detail")
                        println("Error fetching post detail: ${e.message}")
                    }
                }
            }

            MaterialTheme {
                if (errorMessage != null) {
                    Text(
                        text = errorMessage!!,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    when (val response = postDetailResponse) {
                        null -> Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                        else -> {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "帖子详情:",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                response.post?.let {
                                    Text(text = "标题: ${it.title}")
                                    Text(text = "作者: ${it.author}")
                                    Text(text = "创建时间: ${it.created_at}")
                                    Text(text = "内容: ${it.content}")
                                    Text(text = "点赞数: ${it.like_nums}")
                                    Text(text = "是否置顶: ${if (it.is_topped) "是" else "否"}")
                                } ?: run {
                                    Text(text = "没有帖子信息.")
                                }

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
                            }
                        }
                    }
                }
            }
        }
    }
}