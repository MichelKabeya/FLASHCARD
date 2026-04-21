package za.ac.iie.myflashcard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
// modified the app icon background image
// from: https://i.pinimg.com/1200x/a5/2d/d3/a52dd319e9f585b0c66f32696b520c93.jpg

// added background image for activity_main the welcome activity
// from: https://i.pinimg.com/1200x/01/3c/a0/013ca0a8b6959c25a5a2934af5dd1ef9.jpg

        // created a variable that holds the  start button
        // that display a toast message when clicked
        val info = findViewById<Button>(R.id.infoBtn)
        info.setOnClickListener {
            Toast.makeText(this@MainActivity,
                "MYTH OR HACK\n" +
                        "MK Corporation\n" +
                        "Version 1.0 — 2026",
                Toast.LENGTH_LONG ).show()
        }
        // created a variable that holds the explicit intent for the class Card
        val btnGO = findViewById<Button>(R.id.startBtn)
        btnGO.setOnClickListener {
        val intent = Intent(this, Card::class.java)
            startActivity(intent)
        }











        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}