package za.ac.iie.myflashcard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Card : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card)

         // added a background image for activity_card
        // from: https://i.pinimg.com/736x/0b/dd/1d/0bdd1d294cf71b2d2c745785bf2a899d.jpg

        // created a variable that holds the Help button
        val help = findViewById<Button>(R.id.helpBtn)
        help.setOnClickListener {
            // message that explain how to play on the flashcard app
            Toast.makeText(
                this@Card,
                "MYTH OR HACK\n" +
                        "\n" +
                        "Tap \"X\" for Myth  \n" +
                        "Tap \"O\" for Hack  \n" +
                        "\n" +
                        "Put your common sense to the test.",
                Toast.LENGTH_LONG).show()

        }
        //created a variable that holds ths score button
        val score = findViewById<Button>(R.id.scoreBtn)
        // made the score button invisible until all question are answered
        score.visibility = View.GONE
        score.setOnClickListener {
            // variable that holds the intent for the  class Score
            val intent= Intent(this, Score::class.java)
            startActivity(intent)
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}