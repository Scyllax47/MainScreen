package com.example.firstapp.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.firstapp.R
import com.example.firstapp.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize() // Makes it cover the full screen
            .background(Color(0xFF5E4AE3)) // Purple background
    ) {

        Box(
            modifier = Modifier // Modifier for the main white box
                .fillMaxSize()
                .padding(20.dp) // Padding for each side of the screen
                .background(
                    Color.White,
                    shape = RoundedCornerShape(40.dp) // Defines color and rounded corners
                )
        ) {

            Column(
                modifier = Modifier // Modifier for the column that contains the content
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly // Horizontal and vertical alignment to center
            ) {

                // Main image
                Image(
                    painter = painterResource(id = R.drawable.welcome_image),
                    contentDescription = null,
                    modifier = Modifier // Modifier for the main image
                        .height(400.dp) // Image height
                        .width(500.dp) // Image width
                )

                // Title
                Text(
                    text = "Hello",
                    fontSize = 40.sp, // Font size
                    fontWeight = FontWeight.ExtraBold, // Bold
                    color = Color.Black,
                    modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp) // Top padding to bring title closer to subtitle
                )

                // Subtitle
                Text(
                    text = "Welcome To Little Drop, where you manage your daily tasks",
                    textAlign = TextAlign.Center, // Center text
                    color = Color.Gray,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(10.dp,0.dp,10.dp,20.dp) // Horizontal and bottom padding to adjust spacing
                )

                // Login button (simulated with Box)
                Box(
                    modifier = Modifier // Modifier for the Login button
                        .fillMaxWidth() // Fill full width
                        .padding(36.dp,25.dp) // Horizontal padding
                        .height(55.dp) // Button height
                        .background(
                            Color(0xFF5E4AE3),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .clickable {
                            navController.navigate(Screen.Login.route)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Login",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                // Sign Up button (with border)
                Box(
                    modifier = Modifier // Modifier for the Sign Up button
                        .fillMaxWidth()
                        .padding(36.dp,0.dp)
                        .height(55.dp)
                        .border( // Border with button color
                            width = 2.dp,
                            color = Color(0xFF5E4AE3),
                            shape = RoundedCornerShape(30.dp)
                        )
                        .clickable {
                            navController.navigate(Screen.Register.route)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Sign Up",
                        color = Color(0xFF5E4AE3),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                // Small text
                Text(
                    text = "Sign up using",
                    color = Color.Gray,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(0.dp,40.dp,0.dp,10.dp)
                )

                // Social icons
                Row( // Row for social media icons
                    horizontalArrangement = Arrangement.SpaceEvenly, // Equal spacing between elements
                    modifier =
                        Modifier.fillMaxWidth()
                            .padding(85.dp,0.dp,85.dp, 40.dp) // Horizontal padding to reduce space between icons
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = null,
                        modifier = Modifier.size(34.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = null,
                        modifier = Modifier.size(34.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.linkedin),
                        contentDescription = null,
                        modifier = Modifier.size(34.dp)
                    )
                }
            }
        }
    }
}
