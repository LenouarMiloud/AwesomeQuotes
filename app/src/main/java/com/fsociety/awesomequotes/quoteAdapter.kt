package com.fsociety.awesomequotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class quoteAdapter(val context : Context,val quotes:List<String>,val onItemLongClick:(String) -> Unit) : RecyclerView.Adapter<quoteAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.quote_item,parent,false)

        return MyViewHolder(view, onItemLongClick)
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, quoteIndex: Int) {
        viewHolder.bindQuote(quotes[quoteIndex])
    }

    override fun getItemCount(): Int {
        return quotes.count()
    }

    inner class MyViewHolder(itemView: View,onItemLongClick:(String) -> Unit): RecyclerView.ViewHolder(itemView){

        val quoteText = itemView!!.findViewById<TextView>(R.id.textViewQuote)

        fun bindQuote(quote:String){
            quoteText.text = quote
            itemView.setOnLongClickListener{
                onItemLongClick(quote)
                true
            }
        }

    }

}