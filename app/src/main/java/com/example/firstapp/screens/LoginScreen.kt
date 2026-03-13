package com.example.firstapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.firstapp.R
import com.example.firstapp.navigation.Screen

@Composable
fun LoginScreen(navController: NavController) {

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

                // Imagen superior
                Image(
                    painter = painterResource(id = R.drawable.login_image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(300.dp)
                        .width(300.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Titulo
                Text(
                    text = "Login",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(25.dp))

                // NAME
                Text(
                    text = "Name",
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // EMAIL
                Text(
                    text = "Email",
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // PASSWORD
                Text(
                    text = "Password",
                    color = Color.Gray,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Forgot password?",
                    color = Color.LightGray,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(30.dp))

                // BOTON SIGN UP
                Box(
                    modifier = Modifier
                        .align(Alignment.End)
                        .background(
                            Color(0xFF5E4AE3),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .padding(horizontal = 30.dp, vertical = 12.dp)
                    ,
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Sign Up",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}