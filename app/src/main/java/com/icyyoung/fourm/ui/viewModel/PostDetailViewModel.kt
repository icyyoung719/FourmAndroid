package com.icyyoung.fourm.ui.viewModel

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.icyyoung.fourm.data.api.ApiConfig
import com.icyyoung.fourm.data.model.PostDetailResponse

class PostDetailViewModel : ViewModel() {

    private val _postDetail = MutableStateFlow<PostDetailResponse?>(null)
    val postDetail: StateFlow<PostDetailResponse?> = _postDetail

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun loadPostDetail(postId: Int) {
        viewModelScope.launch {
            try {
                val response = ApiConfig.apiService.getPostDetail(postId)
                _postDetail.value = response
                _errorMessage.value = null
                _isLoading.value = false
            } catch (e: Exception) {
                _errorMessage.value = when (e) {
                    is HttpException -> "HTTP 错误: ${e.message}"
                    else -> "无法加载数据，请检查网络连接"
                }
                _isLoading.value = false
            }
        }
    }
}