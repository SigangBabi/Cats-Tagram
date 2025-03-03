package com.example.cats_tagram.activities.main

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cats_tagram.R

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        presenter = MainPresenter(this, MainModel(this))

        val kollyButton = findViewById<Button>(R.id.buttonKolly)
        val lokiButton = findViewById<Button>(R.id.buttonLoki)
        val blueButton = findViewById<Button>(R.id.buttonBlue)
        val dokiButton = findViewById<Button>(R.id.buttonDoki)
        val tilapsButton = findViewById<Button>(R.id.buttonTilaps)
        kollyButton.setOnClickListener {
            presenter.kollyButtonClick()
        }
        lokiButton.setOnClickListener {
            presenter.lokiButtonClick()
        }
        blueButton.setOnClickListener {
            presenter.blueButtonClick()
        }
        dokiButton.setOnClickListener {
            presenter.dokiButtonClick()
        }
        tilapsButton.setOnClickListener {
            presenter.tilapsButtonClick()
        }
    }

    override fun getContext(): Context {
        return requireNotNull(this)
    }

    override fun onLoading() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
    }

    override fun offLoading() {
        findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
    }


}