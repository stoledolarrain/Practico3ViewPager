package com.example.practico3viewpager

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MisLikesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mis_likes)

        // Obtener la lista de nombres de cafeterías "gustadas" desde la MainActivity
        val listaDeCafeteriasGuardadas = intent.getStringArrayListExtra("Cafeterias Guardadas") ?: arrayListOf()

        val listView: ListView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDeCafeteriasGuardadas)
        listView.adapter = adapter
    }
}
