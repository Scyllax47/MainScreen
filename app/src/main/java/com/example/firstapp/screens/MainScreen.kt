package com.example.firstapp.screens

import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import com.example.firstapp.components.Contact

@Composable
fun MainScreen() {

    val contacts = listOf(
        Pair("Juan Pérez", "612-123-4567"),
        Pair("María López", "612-987-6543"),
        Pair("Carlos Ruiz", "612-555-1111")
    )

    LazyColumn{
        items(contacts){
            contact ->
            Contact(name = contact.first, contact.second)
        }
    }
}