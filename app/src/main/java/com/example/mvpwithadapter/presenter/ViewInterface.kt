package com.example.mvpwithadapter.presenter

interface ViewInterface {

    fun showSuccess()
    fun showError()
    fun onLoading()
    fun onListGenerated(list: ArrayList<Int>)
}