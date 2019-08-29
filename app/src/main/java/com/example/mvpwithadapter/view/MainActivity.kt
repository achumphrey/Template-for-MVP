package com.example.mvpwithadapter.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpwithadapter.R
import com.example.mvpwithadapter.presenter.PresenterImp
import com.example.mvpwithadapter.presenter.ViewInterface
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ViewInterface {
    override fun onLoading() {
        prgs_bar.setVisibility(View.VISIBLE)
    }

    private lateinit var presenter: PresenterImp

    override fun showSuccess() {
        prgs_bar.setVisibility(View.GONE)

        Toast.makeText(this,"List is being populated!"
            , Toast.LENGTH_SHORT)
            .show()

    }

    override fun showError() {

    }

    override fun onListGenerated(list: ArrayList<Int>) {
        prgs_bar.setVisibility(View.GONE)
        showSuccess()

        val adapter: NumberListAdapter =
            NumberListAdapter(
                list!!,
                object :
                    OnListClickLister {
                    override fun onListClick(list: Int) {

                        val intent = Intent(this@MainActivity, DisplayActivity::class.java )
                        intent.putExtra("message", list.toString())
                        startActivity(intent)
                    }
                })

        recyclerview_list.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerview_list.adapter = adapter

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = PresenterImp(this)
        presenter.getListNumbers()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
