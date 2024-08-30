package com.example.a511foodapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a511foodapp.MainActivity
import com.example.a511foodapp.R
import com.example.a511foodapp.adapters.CategoryAdapter
import com.example.a511foodapp.models.Category

class HomeActivity : AppCompatActivity() {
    lateinit var username : TextView
    lateinit var logoutBtn : ImageView
    lateinit var categoriesRecyclerview : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        val sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        username = findViewById(R.id.usernameTV)
        logoutBtn = findViewById(R.id.logoutBtn)
        categoriesRecyclerview = findViewById(R.id.categories_recycleview)
        categoriesRecyclerview.adapter = CategoryAdapter(Category.categories)
        categoriesRecyclerview.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        logoutBtn.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()

            val intent = Intent(this@HomeActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}