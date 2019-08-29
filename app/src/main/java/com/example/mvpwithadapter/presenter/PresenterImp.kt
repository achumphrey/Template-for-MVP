package com.example.mvpwithadapter.presenter

import com.example.mvpwithadapter.model.NumberGenerator

class PresenterImp (_view: ViewInterface?): PresenterInterface{

    var view: ViewInterface? = _view
    var numberGenerator = NumberGenerator()

    override fun getListNumbers() {

        val listGenerated:ArrayList<Int> = numberGenerator.getNumbers()

        view?.onListGenerated(listGenerated)
    }

    override fun onDestroy() {
        view = null
    }
}