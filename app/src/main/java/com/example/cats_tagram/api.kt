package com.example.cats_tagram

import retrofit2.Call
import retrofit2.http.GET

interface api {

        @GET("v1/2f8cf26c-047a-4b9f-a2b0-b33aa4e4cfb8")
        fun getData() : Call<List<catDataItem>>
}