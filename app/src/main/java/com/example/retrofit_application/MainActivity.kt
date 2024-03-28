package com.example.retrofit_application

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*
*
* https://jsonplaceholder.typicode.com/posts
* */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val service = RetrofitClient.createService(PostService::class.java)

        val call: Call<List<PostEntity>> = service.list()
        call.enqueue(object : Callback<List<PostEntity>>{
            override fun onResponse(p0: Call<List<PostEntity>>, r: Response<List<PostEntity>>) {
                val response = r.body()
                for(v in response!!.asIterable()){
                    println(v.title)
                }
            }

            override fun onFailure(p0: Call<List<PostEntity>>, p1: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}