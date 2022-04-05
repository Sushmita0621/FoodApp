package com.sushmita.foodapplicationsushmita

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class RegistrationNextActivity : AppCompatActivity() {
    lateinit var textname:TextView
    lateinit var mobile:TextView
    lateinit var email:TextView
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.sharedPreferences),MODE_PRIVATE)
        setContentView(R.layout.activity_registration_next)
        textname=findViewById(R.id.text_name)
        mobile=findViewById(R.id.mobile)
        email=findViewById(R.id.email)

        val name=sharedPreferences.getString("name","user")
        val mb=sharedPreferences.getString("phone","1234567890")
        //val mb1=mb.toString()
        val el=sharedPreferences.getString("email","user@gmail.com")

        textname.text=name
        mobile.text=mb
        email.text=el

    }
}