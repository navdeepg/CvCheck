package com.cvcheck.data

import com.cvcheck.db.entity.AboutMe
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * API Interface to get resume json from gist
 */
interface CVApi {

    @GET("b4e110d33192a860237b30aeb0008275/raw/76eb0a3d80c7f36222274e7d6a24355dab4269e5/about.json")
    fun aboutMe(): Call<AboutMe>

    companion object {
        private const val ENDPOINT = "https://gist.githubusercontent.com/navdeepg/"

        private val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        private val client : OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        private val instance: CVApi by lazy {
            Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()
                    .create(CVApi::class.java)
        }

        fun singleton(): CVApi = instance
    }
}

