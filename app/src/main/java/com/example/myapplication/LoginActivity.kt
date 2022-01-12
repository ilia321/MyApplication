package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {
    private lateinit var editTextEmail:EditText
    private lateinit var editTextPassword:EditText
    private lateinit var editTextConfirmPassword:EditText
    private lateinit var buttonLogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        init()
        listeners()

    }

    private fun init() {
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword)
        buttonLogin = findViewById(R.id.buttonLogin)

    }

    private fun listeners() {
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val confirmpassword = editTextConfirmPassword.text.toString()

            if (email.isEmpty() || password.isEmpty() || confirmpassword.isEmpty()) {
                Toast.makeText(this, "something is missing", Toast.LENGTH_SHORT).show()
            } else if (password != confirmpassword) {
                Toast.makeText(this, "something is incorrect", Toast.LENGTH_SHORT).show()
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
                    }

                }

        }
    }
}

