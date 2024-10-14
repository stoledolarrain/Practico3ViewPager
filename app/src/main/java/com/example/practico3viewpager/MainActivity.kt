package com.example.practico3viewpager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val viewPager2: ViewPager2 = findViewById(R.id.viewPager2)
        val btnNext: Button = findViewById(R.id.btnDislike)

        // Datos de las cafeterías
        val cafes = listOf(
            Cafe(
                listOf(
                    R.drawable.cafecafeto1,
                    R.drawable.cafecafeto2,
                    R.drawable.cafecafeto3,
                    R.drawable.cafecafeto4,
                    R.drawable.cafecafeto5
                ),
                "Cafetería Cafeto"
            ),
            Cafe(
                listOf(
                    R.drawable.cafealtotostado1,
                    R.drawable.cafealtotostado2,
                    R.drawable.cafealtotostado3,
                    R.drawable.cafealtotostado4,
                    R.drawable.cafealtotostado5
                ),
                "Cafetería Alto Tostado"
            ),
            Cafe(
                listOf(
                    R.drawable.cafedelbarrio1,
                    R.drawable.cafedelbarrio2,
                    R.drawable.cafedelbarrio3,
                    R.drawable.cafedelbarrio4,
                    R.drawable.cafedelbarrio5
                ),
                "Cafetería del Barrio"
            ),
            Cafe(
                listOf(
                    R.drawable.cafedoblechocolate1,
                    R.drawable.cafedoblechocolate2,
                    R.drawable.cafedoblechocolate3,
                    R.drawable.cafedoblechocolate4,
                    R.drawable.cafedoblechocolate5
                ),
                "Cafetería Doble Chocolate"
            ),
            Cafe(
                listOf(
                    R.drawable.cafetypica1,
                    R.drawable.cafetypica2,
                    R.drawable.cafetypica3,
                    R.drawable.cafetypica4,
                    R.drawable.cafetypica5
                ),
                "Cafetería Típica"
            )
        )

        // Variable para rastrear el índice actual de la cafetería
        var currentIndex = 0

        // Configura el ViewPagerAdapter inicialmente
        viewPager2.adapter = ViewPagerAdapter(cafes[currentIndex].images, cafes[currentIndex].name)

        btnNext.setOnClickListener {
            // Cambia a la siguiente cafetería
            currentIndex = (currentIndex + 1) % cafes.size
            viewPager2.adapter = ViewPagerAdapter(cafes[currentIndex].images, cafes[currentIndex].name)
        }
    }

    // Clase de datos para representar cada cafetería
    data class Cafe(val images: List<Int>, val name: String)
}
