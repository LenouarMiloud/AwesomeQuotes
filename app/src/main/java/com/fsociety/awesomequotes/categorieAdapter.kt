package com.fsociety.awesomequotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.zip.Inflater

class categorieAdapter(val context:Context,val categories : List<categorie>) : RecyclerView.Adapter<categorieAdapter.myVieHolder>() {

    inner class myVieHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val categorieImage = itemView!!.findViewById<ImageView>(R.id.imageViewCategorieImage)
        val categorieName = itemView!!.findViewById<TextView>(R.id.textViewCategorieName)

        fun bindData(category:categorie,context: Context){
            categorieImage.setImageResource(category.resourceId)
            categorieName.text = category.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myVieHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.categorie_item,parent,false)
        val viewHolder = myVieHolder(view)

        return viewHolder

    }

    override fun onBindViewHolder(holder: myVieHolder, position: Int) {
        holder!!.bindData(categories[position],context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

}