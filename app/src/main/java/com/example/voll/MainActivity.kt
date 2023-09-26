package com.example.voll

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.voll.databinding.ActivityMainBinding
import java.util.UUID
import java.util.concurrent.RecursiveAction
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

class OurRecyclerAdapter(val context: Context, val elements: MutableList<String>):
    RecyclerView.Adapter<OurRecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.uuid)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recy_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    fun update(new: String){
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = elements[position]
    }

}




class MainActivity : AppCompatActivity() {


        // lazy, observable

//    val ourList = mutableListOf<String>()


    var pablo: String by Delegate()
    val ppp: String by lazy{
       Log.d("HEHEHE", "EXECUTING LAMBDA")
       "200"
    }

    var ooo: String by Delegates.observable("Pablo"){a,b,c->
        Log.d("HEHEHE", "something is changed")
    }




    val vollViewModel : VollViewModel by viewModels()
//    {
//        VollViewModelFactory(SavedStateHandle())
//    }

    lateinit var text: TextView

    fun updateText(){
        text.setText(vollViewModel.strList[vollViewModel.index])
    }

    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result -> Log.d("HEHEHE", "")
//        result.resultCode ==
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace (R.id.fragmentContainerView, RecyclerViewFragment())
            commit()
        }



//        text = findViewById(R.id.textView)
//        updateText()
//
//
////        ourList.addAll((1..30).map{UUID.randomUUID().toString()})
//
//
//
//        binding.bind2.setText("200")
//
//        binding.newActivity.setOnClickListener {
//            val intent = Intent(this, ShowHintActivity::class.java)
//            intent.putExtra("HELO", "helo")
////            startActivity(intent)
//            launcher.launch(intent)
//        }
//
//
//
//
//        pablo = "300"
//        Log.d("HEHEHE", "${pablo}")
//
//        val buttonPrev: Button = findViewById(R.id.button)
//        buttonPrev.setOnClickListener {
//            vollViewModel.index = vollViewModel.index  - 1
//            updateText()
//
//        }
//
//        val buttonNext: Button = findViewById(R.id.button2)
//        buttonNext.setOnClickListener {
//            Log.d("HEHEHE", "ppp is ${ppp}")
//            ooo = "${vollViewModel.index} + a"
//            vollViewModel.index = vollViewModel.index  + 1
//            updateText()
//        }
    }
}
