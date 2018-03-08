package com.github.aprofromindia.demoapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
         Toast.makeText(this@MainActivity, "Hello Aperto Engineering", Toast.LENGTH_LONG).show()
        }

        actBtn.setOnClickListener{
            startActivity(Intent(this@MainActivity, DetailActivity::class.java))
        }

        snkButton.setOnClickListener{
            Snackbar.make(it, "Hello Snackbar", Snackbar.LENGTH_LONG).show()
        }

        textView.text = "Something different"
    }
}
