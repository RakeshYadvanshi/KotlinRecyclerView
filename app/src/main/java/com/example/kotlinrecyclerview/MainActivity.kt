package com.example.kotlinrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = StudentAdapter(studentlist)
        recyclerView.adapter = adapter
    }

    //We populate the list directly instead of making a mutable list which has the add function
    private val studentlist = listOf(
        Student("Jon", "jon@jon.com", "Professor at Conestoga"),
        Student("Steve", "sjobs@apple.com", "Cofounder of Apple"),
        Student("Sandeep", "sandeep@sandy.com", "Programmer")
    )
}