package com.example.cats_tagram

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    val baseUrl = "https://mocki.io/"
    val tag = "CHECK_RESPONSE"




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val kollyButton = findViewById<Button>(R.id.buttonKolly)
        kollyButton.setOnClickListener {
            val openKolly = Intent(this,kollyActivity::class.java)
            getAllData(1, openKolly)
        }
    }

    private fun getAllData(idNo: Int, intent: Intent){

        val api = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api::class.java)

        api.getData().enqueue(object : retrofit2.Callback<List<catDataItem>> {
            override fun onResponse(call: Call<List<catDataItem>>, response: Response<List<catDataItem>>) {
                if(response.isSuccessful){
                    val info = response.body()
                    val infos = info?.find { it.id == idNo }
                    infos?.let {
                        intent.putExtra("name", it.name)
                        intent.putExtra("breed", it.breed)
                        intent.putExtra("age", it.age)
                        intent.putExtra("gender", it.gender)
                        intent.putExtra("color", it.color)
                        intent.putExtra("description", it.description)
                        intent.putExtra("favFood", it.favoriteFood)
                        intent.putExtra("behavior", it.behavior)
                        startActivity(intent)

                    }
                }
            }

            override fun onFailure(call: Call<List<catDataItem>>, t: Throwable) {
                Log.i(tag, "onFailure: ${t.message}")
            }

        })
    }


}