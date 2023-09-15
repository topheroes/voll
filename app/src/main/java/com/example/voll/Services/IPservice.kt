package com.example.voll.Services

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject


object IPservice {
    fun getIP(context: Context, url:String, callback:(String)->Unit){

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(context)
        val jsonObject = JSONObject()

        jsonObject.put("title", "foo")
        jsonObject.put("body", "bar")
        jsonObject.put("userId", "1")
        val requestString = jsonObject.toString()

// Request a string response from the provided URL.
            /* val stringRequest = object: StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
                callback( "Response is: ${response}" )
            },
            Response.ErrorListener { callback( "That didn't work!") }){

            override fun getBody(): ByteArray {
                return requestString.toByteArray()
            }

            override fun getBodyContentType(): String {
                return "content-type: application/json; charset: utf-8"
            }
        }*/

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST, url, jsonObject,
            Response.Listener { response ->
                callback("Response: %s".format(response.toString()))
            },
            Response.ErrorListener { error ->
                callback(error.toString())
            }
        )

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)

    }
}