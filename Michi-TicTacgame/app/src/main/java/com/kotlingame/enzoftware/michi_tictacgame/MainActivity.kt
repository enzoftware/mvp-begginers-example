package com.kotlingame.enzoftware.michi_tictacgame

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.kotlingame.enzoftware.michi_tictacgame.R.id.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var button1:Button? = null
    var button2:Button? = null
    var button3:Button? = null
    var button4:Button? = null
    var button5:Button? = null
    var button6:Button? = null
    var button7:Button? = null
    var button8:Button? = null
    var button9:Button? = null

    var playAgainButton:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.bu1) as Button
        button2 = findViewById(R.id.bu2) as Button
        button3 = findViewById(R.id.bu3) as Button
        button4 = findViewById(R.id.bu4) as Button
        button5 = findViewById(R.id.bu5) as Button
        button6 = findViewById(R.id.bu6) as Button
        button7 = findViewById(R.id.bu7) as Button
        button8 = findViewById(R.id.bu8) as Button
        button9 = findViewById(R.id.bu9) as Button
        playAgainButton = findViewById(R.id.playAgainButton) as Button
    }
/*
    fun playAgain(){
        button1!!.isEnabled = true
        //button1!!.setBackgroundResource(R.color.whitebackground)
        button2!!.isEnabled = true
        //button2!!.setBackgroundResource(R.color.whitebackground)
        button3!!.isEnabled = true
        //button3!!.setBackgroundResource(R.color.whitebackground)
        button4!!.isEnabled = true
        //button4!!.setBackgroundResource(R.color.whitebackground)
        button5!!.isEnabled = true
        //button5!!.setBackgroundResource(R.color.whitebackground)
        button6!!.isEnabled = true
        //button6!!.setBackgroundResource(R.color.whitebackground)
        button7!!.isEnabled = true
        //button7!!.setBackgroundResource(R.color.whitebackground)
        button8!!.isEnabled = true
        //button8!!.setBackgroundResource(R.color.whitebackground)
        button9!!.isEnabled = true
        //button9!!.setBackgroundResource(R.color.whitebackground)
        playAgainButton!!.isEnabled = false
    }
*/

    fun buClick(view: View){
        val buSelected:Button = view as Button
        var cellID:Int = 0
        when(buSelected.id){
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }

        //Toast.makeText(this,"ID : "+cellID,Toast.LENGTH_SHORT).show()
        playGame(cellID,buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer:Int = 1

    fun playGame(cellID:Int , buSelected:Button?){

        if(ActivePlayer ==1){
            buSelected!!.text = "X"
            buSelected.setBackgroundResource(R.color.orange)
            player1.add(cellID)
            ActivePlayer = 2
            computerPlayer()
        }else{
            buSelected!!.text = "O"
            buSelected!!.setBackgroundResource(R.color.blue)
            player2.add(cellID)
            ActivePlayer = 1
        }
        buSelected!!.isEnabled = false
        var winner = checkWinner()
        if(winner != -1) {
            Toast.makeText(this, "The winner is player $winner", Toast.LENGTH_LONG).show()
            playAgainButton!!.isEnabled = true
        }
    }

    fun checkWinner():Int{
        var winner = -1

        //row 1

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }

        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }


        //row 2

        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }

        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }


        //row 3

        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }

        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }


        //column 1

        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }

        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }


        //column 2

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }

        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }


        //column 3

        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }

        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }


        //column 2

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }

        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }


        //diagonal 1

        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }

        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        //diagonal 2

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }

        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }

        if(winner != -1) return winner

        return -1

    }

    fun computerPlayer(){

        var emptyCells = ArrayList<Int>()
        for(cellID in 1 .. 9){
            if( !( player1.contains(cellID) || player2.contains(cellID) )){
                emptyCells.add(cellID)
            }
        }

        if(emptyCells.isNotEmpty()){

            val r = Random()
            val randIndex = r.nextInt(emptyCells.size)
            val cellID = emptyCells[randIndex]
            var buSelected: Button ?
            when(cellID){
                1-> buSelected= button1
                2-> buSelected= button2
                3-> buSelected= button3
                4-> buSelected= button4
                5-> buSelected= button5
                6-> buSelected= button6
                7-> buSelected= button7
                8-> buSelected= button8
                9-> buSelected= button9
                else->{
                    buSelected = button1
                }
            }
            playGame(cellID,buSelected)
        }else{
            Toast.makeText(this,"Empate papu :V ",Toast.LENGTH_SHORT).show()
            playAgainButton!!.isEnabled = true
        }

    }



}
