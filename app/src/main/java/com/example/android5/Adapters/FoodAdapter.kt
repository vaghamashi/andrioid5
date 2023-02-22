package com.example.android5.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android5.Database.RoomDB
import com.example.android5.FoodEntity
import com.example.android5.R
import com.example.android5.ShowActivity

class FoodAdapter(list: List<FoodEntity>) : RecyclerView.Adapter<FoodAdapter.FoodHolder>() {
    var foodList = list
    lateinit var context:Context

    class FoodHolder(itemView: View) : ViewHolder(itemView) {
        var txtId = itemView.findViewById<TextView>(R.id.txtId)
        var txtName = itemView.findViewById<TextView>(R.id.txtName)
        var txtPrice = itemView.findViewById<TextView>(R.id.txtPrice)
        var rtFood = itemView.findViewById<RatingBar>(R.id.rtFood)
        var imgDelete = itemView.findViewById<ImageView>(R.id.imgDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        context = parent.context
        return FoodHolder(LayoutInflater.from(parent.context).inflate(R.layout.std_item,parent,false))
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {

        var db = RoomDB.getInstance(context)


        holder.txtId.text = foodList.get(position).id.toString()
        holder.txtName.text = foodList.get(position).name
        holder.txtPrice.text = foodList.get(position).price.toString()
        holder.rtFood.rating = foodList.get(position).rating

        holder.imgDelete.setOnClickListener {

            db.foods().deleteFood(foodList.get(position))
            ShowActivity.update()

        }

    }

}