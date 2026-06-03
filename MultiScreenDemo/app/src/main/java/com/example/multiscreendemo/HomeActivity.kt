package com.example.multiscreendemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Get the email passed from LoginActivity
        val userEmail = intent.getStringExtra("userEmail") ?: "User"

        // Get references to UI elements
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val logoutButton = findViewById<Button>(R.id.logoutButton)

        // Display the user's email
        welcomeText.text = "Welcome, $userEmail!"

        // Set up the logout button click listener
        logoutButton.setOnClickListener {
            // Create an Intent to go back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Clear the activity stack so you can't go back with back button
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
