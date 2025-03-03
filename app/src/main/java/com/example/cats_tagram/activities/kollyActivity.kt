package com.example.cats_tagram.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cats_tagram.R

class kollyActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kolly)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent : Intent = getIntent()

        val name = intent.getStringExtra("name")
        val breed = intent.getStringExtra("breed")
        val gender = intent.getStringExtra("gender")
        val age = intent.getStringExtra("age")
        val color = intent.getStringExtra("color")
        val description = intent.getStringExtra("description")
        val favFood = intent.getStringExtra("favFood")
        val behavior = intent.getStringExtra("behavior")

        findViewById<TextView>(R.id.textViewTitle).setText(name)
        findViewById<TextView>(R.id.textViewName).setText(name)
        findViewById<TextView>(R.id.textViewBreed).setText(breed)
        findViewById<TextView>(R.id.textViewGender).setText(gender)
        findViewById<TextView>(R.id.textViewAge).setText(age)
        findViewById<TextView>(R.id.textViewColor).setText(color)
        findViewById<TextView>(R.id.textViewDescription).setText(description)
        findViewById<TextView>(R.id.textViewFavFood).setText(favFood)
        findViewById<TextView>(R.id.textViewBehavior).setText(behavior)

        val backButton = findViewById<ImageButton>(R.id.backButton)

        backButton.setOnClickListener{
            onBackPressed()
        }


    }
}