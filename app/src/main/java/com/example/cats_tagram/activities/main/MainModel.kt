package com.example.cats_tagram.activities.main

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.cats_tagram.api.catDataItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.cats_tagram.api.apiServices

class MainModel (private val view : MainContract.View) : MainContract.Model {


    val baseUrl = "https://mocki.io/"
    val tag = "CHECK_RESPONSE"

    private val apiService = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(apiServices::class.java)


    override fun fetchCatData(context : Context, idno : Int, intent: Intent) {
        val call = apiService.getData()

        call.enqueue(object : retrofit2.Callback<List<catDataItem>> {
            override fun onResponse(call: Call<List<catDataItem>>, response: Response<List<catDataItem>>
            ) {
                if (response.isSuccessful){
                    val info = response.body()
                    val specificInfo = info?.find { it.id == idno }
                    specificInfo?.let {
                        view.offLoading()
                        intent.putExtra("name", it.name)
                        intent.putExtra("breed", it.breed)
                        intent.putExtra("age", it.age)
                        intent.putExtra("gender", it.gender)
                        intent.putExtra("color", it.color)
                        intent.putExtra("description", it.description)
                        intent.putExtra("favFood", it.favoriteFood)
                        intent.putExtra("behavior", it.behavior)
                        context.startActivity(intent)
                    }
                }
            }

            override fun onFailure(call: Call<List<catDataItem>>, t: Throwable) {
                Log.i(tag, "onFailure: ${t.message}")            }

        })



    }



    /*
    myApiServices.getData().enqueue(object : retrofit2.Callback<List<catDataItem>> {
        override fun onResponse(call: Call<List<catDataItem>>, response: Response<List<catDataItem>>) {
            if(response.isSuccessful){
                val info = response.body()
                val infos = info?.find { it.id == idNo }
                infos?.let {


                }
            }
        }

        override fun onFailure(call: Call<List<catDataItem>>, t: Throwable) {
            Log.i(tag, "onFailure: ${t.message}")
        }

    })
*/

}