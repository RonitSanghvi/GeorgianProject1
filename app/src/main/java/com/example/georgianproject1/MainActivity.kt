package com.example.georgianproject1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGamesBtn = findViewById<Button>(R.id.find_game)
        findGamesBtn.setOnClickListener{
            // Getting the value of spinner
            val gameChoice = findViewById<Spinner>(R.id.game_choice)
            // Getting the selected genre
            val selectedGenre = gameChoice.selectedItem.toString()
            // Get the list of games from 'getGames' function.
            val gameList = getGames(selectedGenre)
            // 'item' will take single item at a time. 'str' takes the old fetched data and add new 'item' to it.
            // Initially, 'str' would be empty.
            val games = gameList.reduce { str, item -> str + '\n' + item }

            // Getting the text view...
             val textShowing = findViewById<TextView>(R.id.games)

            // Printing the games in the textview.
            textShowing.text= games
        }
    }

    fun getGames(genre: String) : List<String>{
        return when (genre){
            "Cars" -> listOf("Asphalt 8", "Asphalt 9")
            "Sports" -> listOf("FIFA","CRICKET")
            "Gun Fights" -> listOf("PUBG","COD")
            "Action" -> listOf("Legend of Zelda","GTA 5")
            else -> {
                listOf("Sorry None Found")
            }
        }
    }

}