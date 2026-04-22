package za.ac.iie.myflashcard

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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
                Toast.LENGTH_LONG
            ).show()

        }
        //created a variable that holds ths score button
        val score = findViewById<Button>(R.id.scoreBtn)
        // made the score button invisible until all question are answered
        score.visibility = View.INVISIBLE
        score.setOnClickListener {
            // variable that holds the intent for the  class Score
            val intent = Intent(this, Score::class.java)
            startActivity(intent)
        }
        // created variable that holds the Nice & Bad textViews
        val cheerNice = findViewById<TextView>(R.id.cheertext1)
        val cheerBad = findViewById<TextView>(R.id.cheertext2)
        val quizDisplay = findViewById<TextView>(R.id.flashCard)
        val goodChoice: String = ("Correct! That's a real time-saver!")
        val wrongChoice: String = ("Wrong! That's just an urban myth")
        // created an array that holds all the statements
        val cards = arrayOf<String>(
            "Swallowed chewing gum stays in your stomach for 7 years",
            "Eating carrots gives you night vision",
            "Turning your pillow to the cold side improves sleep",
            "If you drop food, the 3-second rule saves you",
            "Sleeping with socks on helps you fall asleep faster",
            "Putting your phone in airplane mode charges it faster",
            "Turning it off and on again fixes many tech issues",
            "You can wake up instantly by holding your breath"
        )
        // created array for answers based on booleans
        val check = arrayOf(
            false,
            false,
            true,
            false,
            true,
            true,
            true,
            false
        )
        // declaring HACK & MYTH buttons
        val pressHack = findViewById<Button>(R.id.hackBtn)
        val pressMyth = findViewById<Button>(R.id.mythBtn)
        // created variables that will hold the scores
        var scoreUp = 0
        var scoreDown = 0
        var scorefinal:Int
        // initializing the counter for the score
        var counter = 0
        while (counter < 8) {
            // setting the feedback textview to invisible
            cheerNice.visibility = View.INVISIBLE
            cheerBad.visibility = View.INVISIBLE
            // starting the quiz with the first statement
            quizDisplay.text = cards[counter]
            // added condition to the button HACK
            pressHack.setOnClickListener {
                if (check[counter] == false) {
                    scoreDown = scoreDown + 1
                    cheerBad.visibility = View.VISIBLE
                    cheerBad.text = wrongChoice
                }
                else {
                    cheerNice.visibility = View.VISIBLE
                    cheerNice.text = goodChoice
                    scoreUp = scoreUp + 1
                }
            }
            // added condition to the button MYTH
            pressMyth.setOnClickListener {
                if (check[counter] == true) {
                    cheerNice.visibility = View.VISIBLE
                    cheerNice.text = goodChoice
                    scoreUp = scoreUp + 1
                }
                else {
                    cheerBad.visibility = View.VISIBLE
                    cheerBad.text = wrongChoice
                    scoreDown = scoreDown + 1
                }
            }
            counter = counter + 1

        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}