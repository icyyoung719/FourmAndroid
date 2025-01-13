package com.icyyoung.fourm

import android.annotation.SuppressLint
import android.net.http.HttpException
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment // 确保导入 Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import com.icyyoung.fourm.data.api.ApiConfig
import com.icyyoung.fourm.data.model.UsersResponse
import timber.log.Timber // 如果你使用 Timber 进行日志记录

class MainActivity : ComponentActivity() {
    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 初始化 Timber, 恒为True
        if(true) {
            Timber.plant(Timber.DebugTree())
        }

        setContent {
            var usersResponse by remember { mutableStateOf<UsersResponse?>(null) }
            var errorMessage by remember { mutableStateOf<String?>(null) }

            LaunchedEffect(key1 = Unit) {
                lifecycleScope.launch {
                    try {
                        val response = ApiConfig.apiService.getUsers()
                        usersResponse = response
                        Timber.d("API Response Body: $response")
                    } catch (e: Exception) {
                        errorMessage = when (e) {
                            is HttpException -> "HTTP 错误: ${e.message}"
                            else -> "无法加载数据，请检查网络连接"
                        }
                        Timber.e(e, "Error fetching users")
                        println("Error fetching users: ${e.message}")
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
                    when (val response = usersResponse) {
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
                                    text = "Logged In User:",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                response.user?.let {
                                    Text(text = "Name: ${it.name}")
                                    Text(text = "Email: ${it.email}")
                                } ?: run {
                                    Text(text = "No logged in user.")
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                Text(
                                    text = "All Users:",
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                response.users.forEach { user ->
                                    Text(text = "Name: ${user.name}, Email: ${user.email}")
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