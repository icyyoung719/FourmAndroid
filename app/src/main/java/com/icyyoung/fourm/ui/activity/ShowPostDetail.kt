package com.icyyoung.fourm.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresExtension
import androidx.compose.material3.MaterialTheme
import com.icyyoung.fourm.ui.composable.ShowPostDetailScreen
import com.icyyoung.fourm.ui.viewModel.PostDetailViewModel
import timber.log.Timber

class ShowPostDetail : ComponentActivity() {

    companion object {
        const val EXTRA_POST_ID = "post_id"
        private const val DEFAULT_POST_ID = 3 // 设置默认的帖子 ID
    }

    private val viewModel: PostDetailViewModel by viewModels()

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Timber.treeCount == 0) { // 初始化 Timber, 只初始化一次
            Timber.plant(Timber.DebugTree())
        }

        // 获取 intent 中的 postId，默认值为 3
        val postId = intent.getIntExtra(EXTRA_POST_ID, DEFAULT_POST_ID)

        viewModel.loadPostDetail(postId)

        setContent {
            MaterialTheme {
                ShowPostDetailScreen(viewModel = viewModel)
            }
        }
    }
}