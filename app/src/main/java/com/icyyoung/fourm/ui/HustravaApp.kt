package com.icyyoung.fourm.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.icyyoung.fourm.R
import com.icyyoung.fourm.data.api.ApiConfig
import com.icyyoung.fourm.data.model.IndexResponse
import com.icyyoung.fourm.data.model.Post
import com.icyyoung.fourm.data.model.Stats
import java.time.format.DateTimeFormatter
import kotlinx.coroutines.launch

@Composable
fun HustravaApp(indexResponse: IndexResponse, errorMessage: String?) {
    Scaffold(
        topBar = { AppBar() },
        content = { padding ->
            if (errorMessage != null) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Error: $errorMessage", color = MaterialTheme.colorScheme.error)
                }
            } else {
                MainContent(posts = indexResponse.posts, stats = Stats(users = 100, posts = 500, comments = 2000), modifier = Modifier.padding(padding))
            }
        },
        bottomBar = { Footer() }
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppBar() {
    TopAppBar(
        title = { Text("Hustrava - 专业运动交流社区") },
        actions = {
            IconButton(onClick = { /* 切换主题逻辑 */ }) {
                Icon(painterResource(id = R.drawable.ic_theme), contentDescription = "切换主题")
            }
            // 添加其他按钮...
        }
    )
}

@Composable
fun MainContent(posts: List<Post>, stats: Stats, modifier: Modifier = Modifier) {
    Row(modifier.fillMaxSize()) {
        Sidebar(stats = stats, modifier = Modifier.weight(1f))
        PostsList(posts = posts, modifier = Modifier.weight(3f))
    }
}

@Composable
fun Sidebar(stats: Stats, modifier: Modifier = Modifier) {
    Column(modifier.background(Color.DarkGray).padding(16.dp)) {
        Button(onClick = { /* 创建帖子逻辑 */ }) {
            Text("创建帖子")
        }
        Spacer(Modifier.height(8.dp))
        Text("用户列表", color = Color.White)
        Spacer(Modifier.height(16.dp))
        Text("统计", fontWeight = FontWeight.Bold, color = Color.White)
        Text("用户总数：${stats.users}", color = Color.White)
        Text("帖子总数：${stats.posts}", color = Color.White)
        Text("回复总数：${stats.comments}", color = Color.White)
    }
}

@Composable
fun PostsList(posts: List<Post>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        item {
            if (posts.isNotEmpty()) {
                Text("所有帖子", fontSize = 24.sp, modifier = Modifier.padding(vertical = 8.dp))
            } else {
                Text("没有帖子", modifier = Modifier.padding(vertical = 8.dp))
            }
        }
        items(posts) { post ->
            PostItem(post)
        }
    }
}

@Composable
fun PostItem(post: Post) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { /* 跳转到帖子详情页 */ }
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(post.title, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(4.dp))
            Text("${post.author} 发布于 ${post.created_at}")
        }
        Text("#${post.id}", modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text("© 2024 hustrava. All rights reserved.")
    }
}

//// 预览函数
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    val mockPosts = listOf(
//        Post(id = 1, title = "第一个帖子", author = "张三", created_at = "2024-01-01"),
//        Post(id = 2, title = "第二个帖子", author = "李四", created_at = "2024-01-02")
//    )
//    HustravaApp(posts = mockPosts, errorMessage = null)
//}