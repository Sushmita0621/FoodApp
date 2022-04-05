package com.sushmita.foodapplicationsushmita

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ForgotPasswordNextActivity : AppCompatActivity() {
    lateinit var mobile: TextView
    lateinit var email: TextView
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.sharedPreferences),MODE_PRIVATE)
        setContentView(R.layout.activity_forgot_password_next)
        mobile=findViewById(R.id.mobile)
        email=findViewById(R.id.email)

        val mb1=sharedPreferences.getString("phone","1234567890")
        //val mb=mb1.toString()
        val mb2=sharedPreferences.getString("phoneuser","6969696969")
        val el1=sharedPreferences.getString("email","user@gmail.com")
        val el2=sharedPreferences.getString("emailuser","anotheruser@gmail.com")

        if(mb1==mb2 && el1==el2)
        {
            mobile.text=mb1
            email.text=el1
        }
        else
        {
            mobile.text=mb1
            email.text=el2
        }
    }
}