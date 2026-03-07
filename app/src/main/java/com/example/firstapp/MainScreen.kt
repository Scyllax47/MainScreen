package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Login : Screen("login")
    object Register : Screen("register")
}

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
                        .clickable {
                            navController.navigate(Screen.Register.route)
                        },
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

                Text(
                    text = "Register",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(25.dp))

                // Name
                Text("Name", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Mail
                Text("Mail", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Password
                Text("Password", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Confirm Password
                Text("Confirm Password", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                // Phone
                Text("Phone", modifier = Modifier.fillMaxWidth(), color = Color.Gray)

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
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
                            Color(0xFF5E4AE3),
                            RoundedCornerShape(30.dp)
                        )
                        .clickable {
                            navController.navigate(Screen.Welcome.route)
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Text(
                        text = "Register",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}
class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = Screen.Welcome.route
            ) {

                composable(Screen.Welcome.route) {
                    WelcomeScreen(navController)
                }

                composable(Screen.Login.route) {
                    LoginScreen(navController)
                }

                composable(Screen.Register.route) {
                    RegisterScreen(navController)
                }
            }
        }
    }
}