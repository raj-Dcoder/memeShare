package com.example.memeshare

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMeme()

    }
    private fun loadMeme(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.com/gimme"

        val memeImageView: ImageView = findViewById(R.id.memeImageView)

        // Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url,null,
            { response ->
                val url=response.getString("url")
                Glide.with(this).load(url).into(memeImageView)

            },
            {
                Toast.makeText(this,"something went wrong",Toast.LENGTH_LONG).show()
            })


        // Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }

    fun shareMeme(view: View) {

    }
    fun nextMeme(view: View) {

    }
}