package com.example.a511foodapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.a511foodapp.models.User
import com.example.a511foodapp.ui.HomeActivity

class MainActivity : AppCompatActivity() {
    lateinit var loginBtn : Button
    lateinit var emailET : EditText
    lateinit var passwordET : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged",false)
        val intent = Intent(this@MainActivity,HomeActivity::class.java)
        if(isLogged){
            startActivity(intent)
            finish()
        }

        loginBtn = findViewById(R.id.loginBtn)
        emailET = findViewById(R.id.emailET)
        passwordET = findViewById(R.id.passwordET)
        loginBtn.setOnClickListener {
            Log.i("LOGAPP","Iniciar sesion")
            val email = emailET.text.toString()
            val password = passwordET.text.toString()
            Log.i("EMAIL",email)
            Log.i("PASSWORD",password)
            if(email.isEmpty() || password.isEmpty()){
                Log.i("ERROR","La contraseña o el correo electronico estan vacios")
                return@setOnClickListener
            }
//            var isValidUser = false
//            for(user in User.staticUsers){
//                if(user.email == email && user.password == password){
//                    isValidUser = true
//                }
//            }
            val isValidUser = User.staticUsers.any { user ->
                user.email == email && user.password == password
            }
            if(!isValidUser){
                Log.i("ERROR","El correo o la contraseña no son validos")
                return@setOnClickListener
            }
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged",true)
            editor.apply()
            // Intent implicitos
            // Intent explicitos
            startActivity(intent)
            finish()
        }
    }

}