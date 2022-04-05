package com.sushmita.foodapplicationsushmita

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText

class RegistrationActivity : AppCompatActivity() {
    lateinit var name:EditText
    lateinit var phone:EditText
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var register:Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.sharedPreferences),MODE_PRIVATE)
        setContentView(R.layout.activity_registration)
        name=findViewById(R.id.name)
        phone=findViewById(R.id.phone)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        register=findViewById(R.id.register)
        val name1=name.text.toString()
        val phone1=phone.text.toString()
        //val phone2=phone1.toLong()
        val email1=email.text.toString()
        val password1=password.text.toString()

        sharedPreferences.edit().putString("name",name1).apply()
        sharedPreferences.edit().putString("phone",phone1).apply()
        sharedPreferences.edit().putString("email",email1).apply()
        sharedPreferences.edit().putString("password",password1).apply()

        register.setOnClickListener {
            val intent=Intent(this@RegistrationActivity,RegistrationNextActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}