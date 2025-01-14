//package com.example.yourapp
//
//import android.os.Build
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.viewModels
//import androidx.annotation.RequiresExtension
//import androidx.compose.material3.MaterialTheme
//import com.icyyoung.fourm.ui.composable.
//import com.icyyoung.fourm.ui.theme.YourAppTheme
//import com.icyyoung.fourm.ui.activity.ShowPostDetail.Companion.EXTRA_POST_ID
//import com.icyyoung.fourm.ui.composable.ShowPostDetailScreen
//import com.icyyoung.fourm.ui.viewModel.PostDetailViewModel
//import timber.log.Timber
//
//class ShowLogin : ComponentActivity() {
//    private val viewModel: PostDetailViewModel by viewModels()
//
//    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        viewModel.
//
//        setContent {
//            MaterialTheme {
//                ShowPostDetailScreen(viewModel = viewModel,)
//            }
//        }
//    }
//}