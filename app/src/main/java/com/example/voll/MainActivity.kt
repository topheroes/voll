package com.example.voll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    val strList = listOf("Who is the president of France?", "Who is the president of Japan?", "Who is the president of Germany?")
    var index = 0
    lateinit var text: TextView

    fun updateText(){
        text.setText(strList[index])
    }

    fun incIndex(){
        index = (index+1)%strList.count()
    }

    fun decIndex(){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.textView)
        updateText()

        val buttonPrev: Button = findViewById(R.id.button)
        buttonPrev.setOnClickListener {
            incIndex()
            updateText()
        }
    }
}
