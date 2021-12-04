package com.fsociety.awesomequotes

import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var db:SQLiteDatabase? = null
    var cursor:Cursor? = null
    var categoryAdapte:categorieAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //read the quotes categorie from database
        val myQuotesDatabaseHelper = awesomeQuotesSQLiteOpenHelper(this)
        db = myQuotesDatabaseHelper.readableDatabase

        cursor = db!!.query("quotes_categories", arrayOf("_id","picture_resource_id","name"),
                null,null,null,null,null,)

        //create a list of categorie
        var listOfCategorie = mutableListOf<categorie>()

        while (cursor!!.moveToNext()){
            val categorieId = cursor!!.getInt(0)
            val categorieResourceId = cursor!!.getInt(1)
            val categorieName = cursor!!.getString(2)

            val Categorie: categorie = categorie(categorieId,categorieResourceId,categorieName)
            //add the category to the List
            listOfCategorie.add(Categorie)

            categoryAdapte = categorieAdapter(this,listOfCategorie){categorieId->
                val intent = Intent(this,QuoteDetailActivity::class.java)
                intent.putExtra("QuoteCategoryId",categorieId)
                startActivity(intent)
            }

            //the Layout Manager
            //val categorieLayoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
            val categorieGridLayoutManager = GridLayoutManager(this,2)
            recyclerViewQuotesCategorie.adapter = categoryAdapte
            recyclerViewQuotesCategorie.layoutManager = categorieGridLayoutManager



        }


    }

    override fun onDestroy() {
        super.onDestroy()
        db!!.close()
        cursor!!.close()
    }
}