package com.example.retrofit_application

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {
    companion object{
        private const val URL_BASE: String = "https://jsonplaceholder.typicode.com/"
        private lateinit var INSTANCE: Retrofit

        private fun getRetrofitInstance(): Retrofit{
            val http = OkHttpClient.Builder()
            if(!::INSTANCE.isInitialized){
                INSTANCE = Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .client(http.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return INSTANCE
        }

        fun <S> createService(_class: Class<S>): S{
            return getRetrofitInstance().create(_class)
        }
    }
}