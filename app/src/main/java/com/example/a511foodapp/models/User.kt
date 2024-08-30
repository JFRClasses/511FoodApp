package com.example.a511foodapp.models

data class User(val email : String, val password : String){
    companion object{
        val staticUsers = listOf(
            User(email="juanfr97@hotmail.com",password="12345"),
            User(email="juanfr98@hotmail.com",password="12345"),
            User(email="juanfr99@hotmail.com",password="12345")
        )
    }
}
