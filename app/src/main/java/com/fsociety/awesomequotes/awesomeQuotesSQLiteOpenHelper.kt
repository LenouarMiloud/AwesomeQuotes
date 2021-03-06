package com.fsociety.awesomequotes

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class awesomeQuotesSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(context,null,null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        //create the quote_category table (quotes and categories)
        db!!.execSQL("CREATE TABLE quotes_categories(" +
                "_id INTEGER PRIMARY KEY," +
                "picture_resource_id TEXT," +
                "name TEXT" +
                ")");

        insertQuotesQuategory(db,1,R.drawable.alone,"Alone")
        insertQuotesQuategory(db,2,R.drawable.computer,"Computer")
        insertQuotesQuategory(db,3,R.drawable.gamer,"Gamer")
        insertQuotesQuategory(db,4,R.drawable.love,"Love")

        //Quote Table
        db!!.execSQL("CREATE TABLE quotes(" +
                "quote TEXT," +
                "categoryId INTEGER" +
                ")");
        insertQuote(db,"Love is never Lost ....",1)
        insertQuote(db,"Love is hard ....",1)
        insertQuote(db,"Love is awesome  ....",1)
        insertQuote(db,"Love is never Lost ....",1)
        insertQuote(db,"Love is hard ....",1)
        insertQuote(db,"Love is awesome  ....",1)
        insertQuote(db,"Love is never Lost ....",1)
        insertQuote(db,"Love is hard ....",1)
        insertQuote(db,"Love is awesome  ....",1)
        insertQuote(db,"Love is never Lost ....",1)
        insertQuote(db,"Love is hard ....",1)
        insertQuote(db,"Love is awesome  ....",1)
        insertQuote(db,"Love is never Lost ....",1)
        insertQuote(db,"Love is hard ....",1)
        insertQuote(db,"Love is awesome  ....",1)

        }



    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}
    //function to insert quote in the table
    fun insertQuotesQuategory(db: SQLiteDatabase?,id:Int,ressourceId: Int,name:String){
        val contentValue = ContentValues()
        contentValue.put("_id",id)
        contentValue.put("picture_resource_id",ressourceId)
        contentValue.put("name",name)
        db!!.insert("quotes_categories",null,contentValue)

    }

    fun insertQuote(db: SQLiteDatabase?,quote:String,categoryId:Int) {
        val contentValues = ContentValues()

        contentValues.put("quote", quote)
        contentValues.put("categoryId", categoryId)

        db!!.insert("quotes", null, contentValues)
    }