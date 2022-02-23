package com.mogga.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import com.mogga.diffutil.databinding.ActivityMainBinding
import com.mogga.diffutil.model.Programming

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = Adapter()
        val p1 = Programming(1,"J","Java")
        val p2 = Programming(2,"K","Kotlin")
        val p3= Programming(3,"P","Python")
        adapter.submitList(listOf(p1,p2,p3))
        binding.recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed(
            {
                val p4 = Programming(4,"R","Ruby")
                val p5 = Programming(5,"C","C++")
                val p6 = Programming(1,"J","Java")
                adapter.submitList(listOf(p4,p5,p6))

            },4000)


    }
}