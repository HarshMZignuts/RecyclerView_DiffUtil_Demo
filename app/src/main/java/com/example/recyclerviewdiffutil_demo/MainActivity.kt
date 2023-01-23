package com.example.recyclerviewdiffutil_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdiffutil_demo.module.Item

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val adpter = ItemAdapter()

        val p1 = Item(1,"Harsh")
        val p2 = Item(2,"Dinesh")
        val p3 = Item(3,"Ravi")
        adpter.submitList(listOf( p1,p2,p3))

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
        recycler.adapter = adpter

        Handler(Looper.getMainLooper()).postDelayed({
            val p1 = Item(1,"Harsh")
            val p4 = Item(4,"Manav")
            val p5 = Item(5,"kush")
            val p6 = Item(6,"Jimil")
            adpter.submitList(listOf(p1,p4,p5,p6))

        },5000)

    }
}