package com.example.voll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import kotlin.properties.Delegates
import kotlin.reflect.KProperty


class Delegate{
    operator fun getValue(propRef: Any?, prop: KProperty<*>):String{
        return "propRef ${propRef} and prop ${prop.name}"
    }
    operator fun setValue(propRef: Any?, prop: KProperty<*>, value: String): String{
        return "200"
    }
}


class MainActivity : AppCompatActivity() {


    // lazy, observable

    var pablo: String by Delegate()
    val ppp: String by lazy{
       Log.d("HEHEHE", "EXECUTING LAMBDA")
       "200"
    }

    var ooo: String by Delegates.observable("Pablo"){a,b,c->
        Log.d("HEHEHE", "something is changed")
    }


    val vollViewModel : VollViewModel by viewModels(){
        VollViewModelFactory(SavedStateHandle())
    }

    lateinit var text: TextView

    fun updateText(){
        text.setText(vollViewModel.strList[vollViewModel.index])
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.textView)
        updateText()


        pablo = "300"
        Log.d("HEHEHE", "${pablo}")

        val buttonPrev: Button = findViewById(R.id.button)
        buttonPrev.setOnClickListener {
            vollViewModel.index = vollViewModel.index  - 1
            updateText()

        }

        val buttonNext: Button = findViewById(R.id.button2)
        buttonNext.setOnClickListener {
            Log.d("HEHEHE", "ppp is ${ppp}")
            ooo = "${vollViewModel.index} + a"
            vollViewModel.index = vollViewModel.index  + 1
            updateText()
        }
    }
}
