package com.fsociety.awesomequotes

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class QuoteDetailActivity : AppCompatActivity() {

    var quoteCategoryId = 0
    var db: SQLiteDatabase? = null
    var cursor: Cursor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_detail)

        quoteCategoryId = intent.extras!!.get("QuoteCategoryId").toString().toInt()

        Toast.makeText(this,quoteCategoryId.toString(),Toast.LENGTH_LONG).show()

        //read the data from database
        val myQuoteDatabaseHelper = awesomeQuotesSQLiteOpenHelper(this)
        db = myQuoteDatabaseHelper.readableDatabase
        cursor = db!!.query("quotes", arrayOf())


        //Create an adapter object
        //set the adapter
        //use a layout manager


    }
}