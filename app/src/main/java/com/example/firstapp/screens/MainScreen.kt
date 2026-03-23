package com.example.firstapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.firstapp.components.Contact

data class ContactData(val name: String, val phone: String)

@Composable
fun MainScreen() {

    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    val contacts = remember {
        mutableStateListOf(
            ContactData("Ana García", "+34 612 345 678"),
            ContactData("Carlos Rodríguez", "+34 699 888 777"),
            ContactData("Elena Martínez", "+34 655 443 322")
        )
    }

    // Layout to include bottom navigation bar
    Scaffold(
        bottomBar = { BottomBar() }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Menu, contentDescription = null)
                Text("Mis Contactos", style = MaterialTheme.typography.titleLarge)
                Icon(Icons.Default.AccountCircle, contentDescription = null)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Name input
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Ej: Juan Pérez") },
                label = { Text("Nombre") },
                leadingIcon = { Icon(Icons.Default.Person, null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Phone input
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                placeholder = { Text("+34 600 000 000") },
                label = { Text("Teléfono") },
                leadingIcon = { Icon(Icons.Default.Phone, null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Add button (adds a contact to the list if both fields aren't empty)
            Button(
                onClick = {
                    if (name.isNotBlank() && phone.isNotBlank()) {
                        contacts.add(ContactData(name, phone))
                        name = ""
                        phone = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1E5BEF)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(Icons.Default.PersonAdd, null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Agregar Contacto")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Clean button (clears the content in both input fields above)
            Button(
                onClick = {
                    name = ""
                    phone = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.LightGray
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Icon(Icons.Default.DeleteOutline, null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Limpiar Campos", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "LISTA DE CONTACTOS",
                style = MaterialTheme.typography.labelMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Contact list
            LazyColumn {
                items(contacts) { contact ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Contact(
                            name = contact.name,
                            phone = contact.phone
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun BottomBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { },
            icon = { Icon(Icons.AutoMirrored.Filled.List, null) },
            label = { Text("Contactos") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color(0xFF1E5BEF),
                selectedTextColor = Color(0xFF1E5BEF)
            )
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.History, null) },
            label = { Text("Recientes") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { },
            icon = { Icon(Icons.Default.Star, null) },
            label = { Text("Favoritos") }
        )
    }
}