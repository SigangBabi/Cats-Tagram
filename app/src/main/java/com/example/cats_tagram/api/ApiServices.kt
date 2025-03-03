package com.example.cats_tagram.api

import retrofit2.Call
import retrofit2.http.GET

interface apiServices {

        @GET("v1/2f8cf26c-047a-4b9f-a2b0-b33aa4e4cfb8")
        fun getData() : Call<List<catDataItem>>
}