package com.example.a511foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a511foodapp.R
import com.example.a511foodapp.models.Category

class CategoryAdapter(val categories : List<Category>)
    : RecyclerView.Adapter<CategoryViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryTextView.text = category.name
    }

}

class CategoryViewHolder(view: View) : ViewHolder(view){
    val categoryImage : ImageView = view.findViewById(R.id.category_image)
    val categoryTextView : TextView = view.findViewById(R.id.category_name)
}