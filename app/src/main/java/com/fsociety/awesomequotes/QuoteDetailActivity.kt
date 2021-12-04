package com.fsociety.awesomequotes

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_quote_detail.*
import kotlin.text.Typography.quote

class QuoteDetailActivity : AppCompatActivity() {

    var quoteCategoryId = 0
    var db: SQLiteDatabase? = null
    var cursor: Cursor? = null
    var quoteAdapter: quoteAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote_detail)

        quoteCategoryId = intent.extras!!.get("QuoteCategoryId").toString().toInt()

        Toast.makeText(this,quoteCategoryId.toString(),Toast.LENGTH_LONG).show()

        //read the data from database
        val myQuoteDatabaseHelper = awesomeQuotesSQLiteOpenHelper(this)
        db = myQuoteDatabaseHelper.readableDatabase
        cursor = db!!.query("quotes", arrayOf("quote"),"categoryId=?", arrayOf(quoteCategoryId.toString()),null,null,null)

        var listOfQuote = mutableListOf<String>()
        while (cursor!!.moveToNext()){
            var quote = cursor!!.getString(0)
            listOfQuote.add(quote)
        }

        //Create an adapter object
        quoteAdapter = quoteAdapter(this,listOfQuote){
            //the share intent here
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT,quote)
            shareIntent.type = "text/plain"
            startActivity(shareIntent)
        }

        //use a layout manager
        val layoutManager = LinearLayoutManager(this)
        recyclerViewQuotes.layoutManager = layoutManager
        recyclerViewQuotes.adapter = quoteAdapter

    }

    override fun onDestroy() {
        super.onDestroy()

        db!!.close()
        cursor!!.close()
    }

}