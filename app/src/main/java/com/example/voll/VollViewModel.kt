package com.example.voll

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import java.util.UUID

class VollViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    val strList = listOf("Who is the president of France?", "Who is the president of Japan?", "Who is the president of Germany?")
    val ourList = mutableListOf<String>()

    init{
        ourList.addAll((1..30).map{ UUID.randomUUID().toString()})
    }

    var index:Int
        get(){
            return savedStateHandle.get<Int>("index")?:let{0}
        }
        set(value:Int){
            savedStateHandle.set<Int>("index", value)
        }



}