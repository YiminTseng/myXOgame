package com.example.myxogame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var tvGame: TextView
    private lateinit var tvInfo: TextView
    private lateinit var btnRetry: Button
    var buttons: ArrayList<Button> = arrayListOf()
    var count = 1
    var mark = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //綁定

        btn1 = findViewById<Button>(R.id.btn_1)
        btn2 = findViewById<Button>(R.id.btn_2)
        btn3 = findViewById<Button>(R.id.btn_3)
        btn4 = findViewById<Button>(R.id.btn_4)
        btn5 = findViewById<Button>(R.id.btn_5)
        btn6 = findViewById<Button>(R.id.btn_6)
        btn7 = findViewById<Button>(R.id.btn_7)
        btn8 = findViewById<Button>(R.id.btn_8)
        btn9 = findViewById<Button>(R.id.btn_9)
        tvGame = findViewById(R.id.tv_game)
        tvInfo = findViewById(R.id.tv_info)
        btnRetry = findViewById(R.id.btn_play)
        buttons = arrayListOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)


    }

//覆寫onclick 九宮格共用監聽事件
    override fun onClick(b: View?) {
        var button: Button = b as Button
        var s = count % 2
        if (s == 0) {
            mark = "O"
            button.text = mark
            button.isClickable = false
            tvInfo.text = "It's player X's turn"
        } else {
            mark = "X"
            button.text = mark
            button.isClickable = false
            tvInfo.text = "It's player O's turn"
        }
        count++

        winner()
    }
//play again 的按鈕
    fun playAgain(play: android.view.View) {
        buttonReset()
        msgReset()
    }
//本局結束後將TextView恢復預設文字
    private fun msgReset() {
        tvGame.text = "XO GAME"
        tvInfo.text = "It is player X's turn."
    }
    //本局結束後將Button恢復預設文字及屬性
    private fun buttonReset() {
        count = 1
        buttons.forEach { item ->
            item.isClickable = true
            item.text = "click"
        }
    }
    //電腦下棋
    private fun computer(){
        //TODO()隨機下棋如何找出沒被按過的按鈕

    }

//本局勝負判斷及顯示文字
    private fun winner() {
        when {
                (btn1.text == "X" && btn1.text == btn2.text && btn1.text == btn3.text) ||
                (btn4.text == "X" && btn4.text == btn5.text && btn4.text == btn6.text) ||
                (btn7.text == "X" && btn7.text == btn8.text && btn7.text == btn9.text) ||
                (btn1.text == "X" && btn1.text == btn4.text && btn1.text == btn7.text) ||
                (btn2.text == "X" && btn2.text == btn5.text && btn2.text == btn8.text) ||
                (btn3.text == "X" && btn3.text == btn6.text && btn3.text == btn9.text) ||
                (btn1.text == "X" && btn1.text == btn5.text && btn1.text == btn9.text) ||
                (btn3.text == "X" && btn3.text == btn5.text && btn3.text == btn7.text)
            -> {
                tvGame.text = "Playr X wins!!"
                tvInfo.text = "TRY AGAIN?"
                    buttons.forEach { item ->
                        item.isClickable = false

                    }
                }

            (btn1.text == "O" && btn1.text == btn2.text && btn1.text == btn3.text) ||
            (btn4.text == "O" && btn4.text == btn5.text && btn4.text == btn6.text) ||
            (btn7.text == "O" && btn7.text == btn8.text && btn7.text == btn9.text) ||
            (btn1.text == "O" && btn1.text == btn4.text && btn1.text == btn7.text) ||
            (btn2.text == "O" && btn2.text == btn5.text && btn2.text == btn8.text) ||
            (btn3.text == "O" && btn3.text == btn6.text && btn3.text == btn9.text) ||
            (btn1.text == "O" && btn1.text == btn5.text && btn1.text == btn9.text) ||
            (btn3.text == "O" && btn3.text == btn5.text && btn3.text == btn7.text)
            -> {
                tvGame.text = "Player O wins!!"
                tvInfo.text = "TRY AGAIN?"
                    buttons.forEach { item ->
                    item.isClickable = false

                    }

                }

            count == 10 -> {
                tvGame.text = "No winner,game over!"
                tvInfo.text = "TRY AGAIN?"
            }
        }

    }

}






