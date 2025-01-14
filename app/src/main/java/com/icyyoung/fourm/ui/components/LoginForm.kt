//package com.icyyoung.fourm.ui.components
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.unit.dp
//import com.icyyoung.fourm.R
//
//@Composable
//fun LoginForm(
//    modifier: Modifier = Modifier,
//    onLoginClick: (String, String) -> Unit
//) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    Column(modifier = modifier.padding(16.dp)) {
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text(stringResource(id = R.string.email_label)) },
//            placeholder = { Text(stringResource(id = R.string.email_placeholder)) },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text(stringResource(id = R.string.password_label)) },
//            placeholder = { Text(stringResource(id = R.string.password_placeholder)) },
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = { onLoginClick(email, password) },
//            modifier = Modifier.align(Alignment.End)
//        ) {
//            Text(stringResource(id = R.string.login_button))
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        TextButton(onClick = { /* Navigate to find_password */ }) {
//            Text(stringResource(id = R.string.forgot_password))
//        }
//    }
//}