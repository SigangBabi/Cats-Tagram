package com.example.cats_tagram.activities.main

import android.content.Context
import android.content.Intent

interface MainContract {
    interface View {

        fun getContext(): Context

        fun onLoading ()

        fun offLoading()


    }

    interface Model{

        fun fetchCatData(context : Context, idNo : Int, intent: Intent)


    }

    interface Presenter {

        fun kollyButtonClick()

        fun lokiButtonClick()

        fun blueButtonClick()

        fun dokiButtonClick()

        fun tilapsButtonClick()
    }
}