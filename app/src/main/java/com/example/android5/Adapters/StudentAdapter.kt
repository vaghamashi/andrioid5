package com.example.android5.Adapters

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.android5.Database.Database
import com.example.android5.R
import com.example.android5.StudentModel

class StudentAdapter(list: ArrayList<StudentModel>) : Adapter<StudentAdapter.StudentHolder>() {
    var list = list
    lateinit var context:Context
    lateinit var database: Database
    class StudentHolder(itemView: View) : ViewHolder(itemView) {
        var txtId = itemView.findViewById<TextView>(R.id.txtId)
        var txtName = itemView.findViewById<TextView>(R.id.txtName)
        var txtSurname = itemView.findViewById<TextView>(R.id.txtSurname)
        var txtAddress = itemView.findViewById<TextView>(R.id.txtAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        context = parent.context
        return StudentHolder(LayoutInflater.from(parent.context).inflate(R.layout.std_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {

        database = Database(context)

        holder.txtId.text = list.get(position).id.toString()
        holder.txtName.text = list.get(position).name
        holder.txtSurname.text = list.get(position).surname
        holder.txtAddress.text = list.get(position).address

        holder.itemView.setOnClickListener {
            var dialog = Dialog(context)
            dialog.setContentView(R.layout.data_update)

            var did = dialog.findViewById<TextView>(R.id.edtId)
            var dname = dialog.findViewById<EditText>(R.id.edtName)
            var dsurname = dialog.findViewById<EditText>(R.id.edtSurname)
            var daddress = dialog.findViewById<EditText>(R.id.edtAddress)
            var btnUpdate = dialog.findViewById<Button>(R.id.btnUpdate)

            did.text = list.get(position).id.toString()
            dname.setText( list.get(position).name)
            dsurname.setText( list.get(position).surname)
            daddress.setText( list.get(position).address)

            btnUpdate.setOnClickListener {

                database.updateData(
                    dname.text.toString(),
                    dsurname.text.toString(),
                    daddress.text.toString(),
                    did.text.toString().toInt()
//                    list.get(position).id
                )
                dialog.dismiss()
            }


            dialog.show()
        }
    }
}

