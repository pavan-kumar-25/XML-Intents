package com.example.two_activity_xml

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val submitButton = findViewById<Button>(R.id.submitButton)
        val instagramButton = findViewById<Button>(R.id.instagramButton)
        val facebookButton = findViewById<Button>(R.id.facebookButton)
        val linkedinButton = findViewById<Button>(R.id.linkedinButton)

        submitButton.setOnClickListener {
            val nameEditText = findViewById<EditText>(R.id.nameEditText)
            val emailEditText = findViewById<EditText>(R.id.emailEditText)
            val messageEditText = findViewById<EditText>(R.id.messageEditText)

            val name = nameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()
            val message = messageEditText.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || message.isEmpty()) {
                Snackbar.make(it, "Please fill in all fields", Snackbar.LENGTH_SHORT).show()
            } else {
                // All fields are filled, proceed with submission
                Snackbar.make(it, "Recorded successfully", Snackbar.LENGTH_SHORT).show()
            }
        }


        instagramButton.setOnClickListener {
            openUrlInBrowser("https://www.instagram.com/")
            Snackbar.make(it, "Instagram Page", Snackbar.LENGTH_SHORT).show()
        }

        facebookButton.setOnClickListener {
            openUrlInBrowser("https://www.facebook.com/")
            Snackbar.make(it, "Facebook Page", Snackbar.LENGTH_SHORT).show()
        }

        linkedinButton.setOnClickListener {
            openUrlInBrowser("https://www.linkedin.com/")
            Snackbar.make(it, "Linkedin Page", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun openUrlInBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}

