package com.example.lesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NullPointerException

class MainActivity : AppCompatActivity() {


    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        val editText: EditText? = findViewById(R.id.editTextTextPersonName)
        val button: Button? = findViewById(R.id.buttonName)
        textView = findViewById(R.id.textView)


        button?.isEnabled = false
        editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // Nothing to do
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                // Nothing to do
            }

            override fun afterTextChanged(editable: Editable) {
                button?.isEnabled = !TextUtils.isEmpty(editable)
            }
        })

        button?.setOnClickListener {
            val name = "My name is: " + editText?.text.toString()
            textView?.text = name
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString(TEXT_VIEW_TEXT_KEY, textView?.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.getString(TEXT_VIEW_TEXT_KEY)?.let {
        textView?.text = it
        }
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        const val TEXT_VIEW_TEXT_KEY = "TEXT_VIEW_TEXT_KEY"
    }

}