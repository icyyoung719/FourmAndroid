//package com.icyyoung.fourm.ui.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import com.icyyoung.fourm.R
//import com.icyyoung.fourm.ui.components.LoginForm
//
//@Composable
//fun LoginScreen(
//    modifier: Modifier = Modifier,
//    onLoginSuccess: () -> Unit
//) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .verticalScroll(rememberScrollState())
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
////        Image(
////            painter = painterResource(id = R.drawable.logo),
////            contentDescription = null,
////            modifier = Modifier.size(96.dp)
////        )
//
//        Spacer(modifier = Modifier.height(32.dp))
//
////        Text(
////            text = stringResource(id = R.string.login_title),
////            style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
////        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        LoginForm(
//            onLoginClick = { email, password ->
//                // 这里应该调用 ViewModel 或其他逻辑来处理登录请求
//                // 模拟登录成功后的动作
//                onLoginSuccess()
//            }
//        )
//    }
//}