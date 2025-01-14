//package com.icyyoung.fourm.ui.components
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import com.icyyoung.fourm.data.model.User
//
//@Composable
//fun Header(user: User? = null) {
//    val isDropdownExpanded = remember { mutableStateOf(false) }
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // Logo or Title
//        Text(
//            text = "论坛",
//            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
//            modifier = Modifier.clickable { /* Handle click */ }
//        )
//
//        Spacer(modifier = Modifier.width(8.dp))
//
//        if (user != null) {
//            // Dropdown for logged-in user
//            Box {
//                Button(onClick = { isDropdownExpanded.value = !isDropdownExpanded.value }) {
//                    Text(text = user.name)
//                }
//
//                DropdownMenu(
//                    expanded = isDropdownExpanded.value,
//                    onDismissRequest = { isDropdownExpanded.value = false }
//                ) {
//                    DropdownMenuItem(
//                        text = { Text("个人主页") },
//                        onClick = {
//                            navController.navigate("/user/${user.email}")
//                            isDropdownExpanded.value = false
//                        }
//                    )
//                    DropdownMenuItem(
//                        text = { Text("设置") },
//                        onClick = {
//                            navController.navigate("/settings/")
//                            isDropdownExpanded.value = false
//                        }
//                    )
//                    Divider(color = Color.Gray, thickness = 1.dp)
//                    DropdownMenuItem(
//                        text = { Text("退出登录", color = Color.Red) },
//                        onClick = {
//                            navController.navigate("/logout/")
//                            isDropdownExpanded.value = false
//                        }
//                    )
//                }
//            }
//        } else {
//            // Buttons for login and register when not logged in
//            Row {
//                Button(onClick = { navController.navigate("/login/") }) {
//                    Text("登录")
//                }
//                Spacer(modifier = Modifier.width(8.dp))
//                Button(onClick = { navController.navigate("/register/") }) {
//                    Text("注册")
//                }
//            }
//        }
//    }
//}