package com.example.voll

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity


class ShowHintActivity: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_show_hint)

        val helo = intent.getStringExtra("HELO")
        Log.d("HELLO", "${helo}")
        //
        // Activity.RESULT_OK
        // Activity.RESULT_CANCELLED
//        Activity.RESULT_FIRST_USER
        // const val MY_SUPER_RESULT = Activity.RESULT_FIRST_USER + 1
        setResult(Activity.RESULT_OK)
        finish()
    }



}