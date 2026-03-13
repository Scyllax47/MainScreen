package com.example.firstapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.firstapp.navigation.Screen

@Composable
fun RegisterScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5E4AE3))
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .background(
                    Color.White,
                    shape = RoundedCornerShape(40.dp)
                )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .align (Alignment.Start)
                        .height(55.dp)
                        .width(120.dp)
                        .background(
                            Color(0xFF5E4AE3),
                            RoundedCornerShape(30.dp)
                        )
                        .clickable {
                            navController.navigate(Screen.Welcome.route)
                        }
                    ,
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Back",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Text(
                    text = "Register",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(25.dp))

                // Statuses
                var name by remember { mutableStateOf("") }
                var nameError by remember { mutableStateOf(false) }
                var mail by remember { mutableStateOf("") }
                var mailError by remember { mutableStateOf(false) }
                var password by remember { mutableStateOf("") }
                var confirmPassword by remember { mutableStateOf("") }
                var confirmPasswordError by remember { mutableStateOf(false) }
                var phone by remember { mutableStateOf("") }
                var phoneError by remember { mutableStateOf(false) }

                fun isValidEmail(email: String) : Boolean{
                    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                }

                fun isValidName(name:String) : Boolean{
                    return name.isNotEmpty() && name.all {it.isLetter() || it.isWhitespace() }
                }

                fun isValidPhone(phone:String) : Boolean{
                    return phone.length == 10 && phone.all { it.isDigit() }
                }

                fun passwordMatches(password: String, confirmPassword: String) : Boolean{
                    return password == confirmPassword
                }

                val isFormValid =
                    isValidName(name) &&
                    isValidEmail(mail) &&
                    isValidPhone(phone) &&
                    password.isNotEmpty() &&
                    passwordMatches(password, confirmPassword)

                // Name
                Text("Name", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                        nameError = !isValidName(it)},
                    isError = nameError,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Mail
                Text("Mail", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = mail,
                    onValueChange = {
                        mail = it
                        mailError = !isValidEmail(it)},
                    isError = mailError,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Password
                Text("Password", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        password = it
                        confirmPasswordError = !passwordMatches(it, confirmPassword)},
                    isError = confirmPasswordError,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Confirm Password
                Text("Confirm Password", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = {
                        confirmPassword = it
                        confirmPasswordError = !passwordMatches(password, it)},
                    isError = confirmPasswordError,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Phone
                Text("Phone", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = phone,
                    onValueChange = {
                        phone = it
                        phoneError = !isValidPhone(it)},
                    isError = phoneError,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Register Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp)
                        .background(
                            if(isFormValid) {
                                Color(0xFF5E4AE3)
                            }else Color.Gray,
                            RoundedCornerShape(30.dp)
                        )
                        .clickable(enabled = isFormValid){
                            // here goes the register actions
                        }
                    ,
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Accept",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}