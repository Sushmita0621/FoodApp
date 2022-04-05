package com.sushmita.foodapplicationsushmita

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginNextActivity : AppCompatActivity() {
    lateinit var textname:TextView
    lateinit var mobile:TextView
    lateinit var email:TextView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var logout:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.sharedPreferences),MODE_PRIVATE)
        setContentView(R.layout.activity_login_next)
        textname=findViewById(R.id.text_name)
        mobile=findViewById(R.id.mobile)
        email=findViewById(R.id.email)
        logout=findViewById(R.id.logout)
        val name=sharedPreferences.getString("name","user")
        val phone=sharedPreferences.getString("phone","1234567890")
        //val ph=phone.toString()
        val email1=sharedPreferences.getString("email","user@gmail.com")

        textname.text=name
        mobile.text=phone
        email.text=email1

        logout.setOnClickListener {
            sharedPreferences.edit().putBoolean("isLoggedIn",false).apply()
            finish()
        }
    }
}