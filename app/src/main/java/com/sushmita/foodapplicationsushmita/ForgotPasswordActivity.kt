package com.sushmita.foodapplicationsushmita

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var phone:EditText
    lateinit var email:EditText
    lateinit var register:Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.sharedPreferences),MODE_PRIVATE)
        setContentView(R.layout.activity_forgot_password)
        phone=findViewById(R.id.phone)
        email=findViewById(R.id.email)
        register=findViewById(R.id.register)
        val phone1=phone.text.toString()
        //val phone2=phone1.toInt
        val email1=email.text.toString()

        sharedPreferences.edit().putString("phoneuser",phone1).apply()
        sharedPreferences.edit().putString("emailuser",email1).apply()
        register.setOnClickListener {
            val intent=Intent(this@ForgotPasswordActivity,ForgotPasswordNextActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}