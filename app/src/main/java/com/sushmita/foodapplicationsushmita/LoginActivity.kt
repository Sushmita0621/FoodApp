package com.sushmita.foodapplicationsushmita

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var phone:EditText
    lateinit var password:EditText
    lateinit var enter:Button
    lateinit var forgotpassword:TextView
    lateinit var signin:TextView
    lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.sharedPreferences),MODE_PRIVATE)
        setContentView(R.layout.activity_login)
        val isLoggedIn=sharedPreferences.getBoolean("isLoggedIn",false)
        if(isLoggedIn)
        {
            val intent=Intent(this@LoginActivity,LoginNextActivity::class.java)
            startActivity(intent)
            finish()
        }
        phone=findViewById(R.id.phone)
        password=findViewById(R.id.password)
        enter=findViewById(R.id.enter)
        forgotpassword=findViewById(R.id.forgot_password)
        signin=findViewById(R.id.signin)

        enter.setOnClickListener{
            val ph=phone.text.toString()
            val pass=password.text.toString()
            val ph1=sharedPreferences.getString("phone","1234567890")
            val pass1=sharedPreferences.getString("password","wrong")
            //val ph2=ph.toLong()

            if(ph==ph1 && pass==pass1)
            {
                savePreferences()
                val intent=Intent(this@LoginActivity,LoginNextActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this@LoginActivity,"Wrong Credentials Entered! Try Again",Toast.LENGTH_LONG).show()
            }
        }
        forgotpassword.setOnClickListener {
            val intent=Intent(this@LoginActivity,ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
        signin.setOnClickListener {
            val intent=Intent(this@LoginActivity,RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun savePreferences(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }
}