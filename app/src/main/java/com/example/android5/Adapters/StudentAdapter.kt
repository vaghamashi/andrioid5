package com.example.android5.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android5.R
import com.example.android5.StudentModel

class StudentAdapter(list: ArrayList<StudentModel>) : Adapter<StudentAdapter.StudentHolder>() {
    var list = list
    class StudentHolder(itemView: View) : ViewHolder(itemView) {
        var txtId = itemView.findViewById<TextView>(R.id.txtId)
        var txtName = itemView.findViewById<TextView>(R.id.txtName)
        var txtSurname = itemView.findViewById<TextView>(R.id.txtSurname)
        var txtAddress = itemView.findViewById<TextView>(R.id.txtAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        return StudentHolder(LayoutInflater.from(parent.context).inflate(R.layout.std_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.txtId.text = list.get(position).id.toString()
        holder.txtName.text = list.get(position).name.toString()
        holder.txtSurname.text = list.get(position).surname.toString()
        holder.txtAddress.text = list.get(position).address.toString()
    }

}