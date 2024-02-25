package com.example.two_activity_xml

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val greetingTextView = findViewById<TextView>(R.id.greetingTextView)
        val moveToNextActivityButton = findViewById<Button>(R.id.moveToNextActivityButton)
        val verifyButton = findViewById<Button>(R.id.verifyButton)
        val riddleTextView = findViewById<TextView>(R.id.riddleTextView)
        val riddleAnswerEditText = findViewById<EditText>(R.id.riddleAnswerEditText)

        val username = intent.getStringExtra("USERNAME") ?: "User"
        greetingTextView.text = "Hello $username"

        // Retrieve a random riddle and set it to the TextView
        val randomRiddle = getRandomRiddle()
        riddleTextView.text = randomRiddle

        moveToNextActivityButton.setOnClickListener {view: View->
            val next = Intent(this, MainActivity3:: class.java)
            startActivity(next)
            // Implement logic to move to the next activity
        }

        verifyButton.setOnClickListener {
            val userAnswer = riddleAnswerEditText.text.toString().trim()
            val correctAnswer = getCorrectAnswer(randomRiddle)

            if (userAnswer.equals(correctAnswer, ignoreCase = true)) {
                // Display a Snackbar for correct answer
                Snackbar.make(it, "Your answer is correct!", Snackbar.LENGTH_SHORT).show()
            } else {
                // Display a hint
                Snackbar.make(it, "Incorrect! Try again.", Snackbar.LENGTH_SHORT).show()
                // You can implement further logic for providing hints here
            }
        }
    }

    private fun getRandomRiddle(): String {
        // Implement logic to fetch a random riddle
        return "What has keys but can't open locks?"
    }

    private fun getCorrectAnswer(riddle: String): String {
        // Implement logic to get the correct answer for the riddle
        // For simplicity, let's assume a fixed answer for each riddle
        return when (riddle) {
            "What has keys but can't open locks?" -> "Keyboard"
            else -> ""
        }
    }
}
