package com.example.kotlinrecyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter (public val list: List<Student>): RecyclerView.Adapter<StudentAdapter.PersonHolder>(){

    //Similar to the normal one
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PersonHolder(inflater, parent)
    }

    //Instead of using the "get" method, we can access it directly
    //Furthermore, notice that we don't use "setText", we now set the properties directly

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        val person: Student = list[position]
        holder.txtEmail.text = person.email
        holder.txtFirstName.text = person.firstName
        holder.itemView.setOnClickListener {
            val i = Intent(it.context, StudentDetailActivity::class.java)
            i.putExtra("email", person.email)
            i.putExtra("name", person.firstName)
            i.putExtra("info", person.info)
            it.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int = list.size

    //Normally most of this code goes inside a public constructor for our RecyclerView
    //Here notice that the inflater is put directly in the constructor

    class PersonHolder(inflater: LayoutInflater, parent: ViewGroup)
        : RecyclerView.ViewHolder(inflater.inflate(R.layout.student_item, parent, false))
    {

        val txtFirstName : TextView = itemView.findViewById(R.id.txtName)
        val txtEmail : TextView = itemView.findViewById(R.id.txtEmail)
    }
}