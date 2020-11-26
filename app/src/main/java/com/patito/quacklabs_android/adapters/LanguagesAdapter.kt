package com.patito.quacklabs_android.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.patito.quacklabs_android.R


class LanguagesAdapter(val languages: List<String>) : RecyclerView.Adapter<LanguagesAdapter.ViewHolder>() {
    inner class ViewHolder(listItem: View) : RecyclerView.ViewHolder(listItem) {
        val tvLanguage: TextView = itemView.findViewById(R.id.tvLanguage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val languagesView = inflater.inflate(R.layout.item_language, parent, false)
        return ViewHolder(languagesView)
    }

    override fun getItemCount(): Int {
        return languages.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val language: String = languages.get(position)
        holder.tvLanguage.text = language
    }
}