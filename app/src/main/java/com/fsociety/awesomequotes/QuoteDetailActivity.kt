package com.fsociety.awesomequotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class QuoteDetailActivity : AppCompatActivity() {

    var quoteCategoryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_detail)

        quoteCategoryId = intent.extras!!.get("QuoteCategoryId").toString().toInt()

        Toast.makeText(this,quoteCategoryId.toString(),Toast.LENGTH_LONG).show()

    }
}