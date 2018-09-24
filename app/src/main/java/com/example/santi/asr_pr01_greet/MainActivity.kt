package com.example.santi.asr_pr01_greet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clicks()
    }

    private fun clicks() {
        btnGreet.setOnClickListener {
            if (txtName.text.isEmpty() && txtSurname.text.isEmpty()){
                cleanData()
                Toast.makeText(this,getString(R.string.you_must_fill_the_fields), Toast.LENGTH_SHORT).show()
            }else{
                when(chkPolite.isChecked){
                    false -> {
                        lblGreet.text = String.format("Welcome %s %s", txtName.text, txtSurname.text)
                    }
                    true -> {
                        lblGreet.text = String.format("Welcome Mr/Ms %s %s",  txtName.text, txtSurname.text)
                    }
                }
            }
        }

        btnReset.setOnClickListener {
            cleanData()
        }

    }

    private fun cleanData() {
        txtName.text = null
        txtSurname.text = null
        lblGreet.text = ""
        chkPolite.isChecked = false
    }

}
