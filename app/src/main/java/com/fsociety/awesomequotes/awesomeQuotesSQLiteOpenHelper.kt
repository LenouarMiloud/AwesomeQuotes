package com.fsociety.awesomequotes

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class awesomeQuotesSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context,"AwesomeQuotes",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        //create the quote table (quotes and categories)
        db!!.execSQL("CREATE TABLE quotes_categories(" +
                "id INTEGER PRIMARY KEY" +
                "picture_resource_id TEXT" +
                "name TEXT" +
                ")");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}