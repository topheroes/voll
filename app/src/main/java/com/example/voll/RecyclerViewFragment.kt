package com.example.voll

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
//import kotlinx.atomicfu.*

class RecyclerViewFragment : Fragment() {

    val vollViewModel:VollViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        findNavController().navigate

        // coroutine
        //coroutine builder
        // launch

        Log.d("HEHEHE", "1")

//        Dispatchers.Default
//        Dispatchers.IO
//        Dispatchers.Main

        suspend fun getTodo():String{
            val client = HttpClient(CIO)
            val todo = client.get<String>("https://jsonplaceholder.typicode.com/todos/1")
            return todo
        }


//        runBlocking {
//
//        }

        // suspend fun
//        CoroutineContext
        // returns Job
        // GSON?
        // race condition

        var counter = 0

        GlobalScope.launch {

            repeat(5000){
                GlobalScope.launch {
                    counter += 1
                }
            }

            Log.d("HEHEHE", "counter is $counter")

        }


//        val job = GlobalScope.launch( CoroutineName("Babbo")) {
////            Log.d("HEHEHE", "${coroutineContext}")
//
//            val toda = getTodo()
//            Log.d("HEHEHE", "toda is $toda")
//            withContext(Dispatchers.Main ){
////                Log.d("HEHEHE", "${coroutineContext}")
//            }
//            delay(3000)
//            Log.d("HEHEHE", "2")
//        }

//        val job2 = GlobalScope.launch {
//
//            while(isActive){
//
//            }
//            job.join()
//            Log.d("HEHEHE", "4")
//        }


        Log.d("HEHEHE", "3")

        val recy = view.findViewById<RecyclerView>(R.id.frag_rec)

        Log.d("HEHEHE", "list length is ${vollViewModel.ourList.count()}")

        recy.layoutManager = LinearLayoutManager(requireContext())
        recy.adapter = OurRecyclerAdapter(requireContext(), vollViewModel.ourList)

    }


}