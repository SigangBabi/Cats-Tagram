package com.example.cats_tagram.activities.main

import android.content.Intent
import com.example.cats_tagram.activities.blueActivity
import com.example.cats_tagram.activities.dokiActivity
import com.example.cats_tagram.activities.kollyActivity
import com.example.cats_tagram.activities.lokiActivity
import com.example.cats_tagram.activities.tilapsActivity

class MainPresenter(
    private val view: MainContract.View,
    private val model: MainContract.Model
) : MainContract.Presenter
{
    override fun kollyButtonClick() {
        view.onLoading()
        val openKolly = Intent(view.getContext(), kollyActivity::class.java)
        model.fetchCatData(view.getContext(), 1, openKolly)
    }

    override fun lokiButtonClick() {
        view.onLoading()
        val openLoki = Intent(view.getContext(), lokiActivity::class.java)
        model.fetchCatData(view.getContext(), 2, openLoki)
    }

    override fun blueButtonClick() {
        view.onLoading()
        val openBlue = Intent(view.getContext(), blueActivity::class.java)
        model.fetchCatData(view.getContext(), 3, openBlue)
    }

    override fun dokiButtonClick() {
        view.onLoading()
        val openDoki = Intent(view.getContext(), dokiActivity::class.java)
        model.fetchCatData(view.getContext(), 4, openDoki)
    }

    override fun tilapsButtonClick() {
        view.onLoading()
        val openTilaps = Intent(view.getContext(), tilapsActivity::class.java)
        model.fetchCatData(view.getContext(), 5, openTilaps)
    }



}