package com.example.two_activity_xml

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText = findViewById<TextInputEditText>(R.id.usernameEditText)
        val passwordEditText = findViewById<TextInputEditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fields can't be empty", Toast.LENGTH_SHORT).show()
            } else if (!isValidCredentials(username, password)) {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            } else {
                // Pass the username to MainActivity2
                val nextIntent = Intent(this, MainActivity2::class.java)
                nextIntent.putExtra("USERNAME", username)
                startActivity(nextIntent)
            }
        }
    }

    // Example of a simple validation function. You can expand this according to your requirements.
    private fun isValidCredentials(username: String, password: String): Boolean {
        // Add your validation logic here
        return username == "pavan" && password == "pass"
    }
}
