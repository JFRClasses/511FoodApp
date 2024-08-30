package com.example.a511foodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.a511foodapp.R
import com.example.a511foodapp.models.Restaurant

class RestaurantAdapter(val restaurantList: List<Restaurant>)
    : RecyclerView.Adapter<RestaurantViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return restaurantList.count()
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}

class RestaurantViewHolder(view:View):ViewHolder(view){

}