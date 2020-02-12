package com.cvcheck.data

import com.cvcheck.db.entity.AboutMe
import com.cvcheck.db.entity.Experience
import com.cvcheck.db.entity.Skill
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

    @GET("a375e01aac742a569b78554923a6c587/raw/2900e8e9fc052d29ce0a2635d816f0450b490cfc/cv.json")
    fun skill(): Call<Skill>

    @GET("733a420eb604f6ab0479175a03c87d72/raw/8699144ffef10f6bc407701de00fdb979eb0cb09/experience.json")
    fun experience(): Call<Experience>

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

