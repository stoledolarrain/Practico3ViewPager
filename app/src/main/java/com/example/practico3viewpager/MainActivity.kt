package com.example.practico3viewpager

import ViewPagerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val viewPager2: ViewPager2 = findViewById(R.id.viewPager2)
        val btnDislike: Button = findViewById(R.id.btnDislike)
        val btnMeLike: Button = findViewById(R.id.btnMeLike)
        val btnMisLikes: Button = findViewById(R.id.btnMisLikes)

        val cafes = listOf(
            Cafeteria(
                listOf(
                    R.drawable.cafecafeto1,
                    R.drawable.cafecafeto2,
                    R.drawable.cafecafeto3,
                    R.drawable.cafecafeto4,
                    R.drawable.cafecafeto5
                ),
                "Cafetería Cafeto"
            ),
            Cafeteria(
                listOf(
                    R.drawable.cafealtotostado1,
                    R.drawable.cafealtotostado2,
                    R.drawable.cafealtotostado3,
                    R.drawable.cafealtotostado4,
                    R.drawable.cafealtotostado5
                ),
                "Cafetería Alto Tostado"
            ),
            Cafeteria(
                listOf(
                    R.drawable.cafedelbarrio1,
                    R.drawable.cafedelbarrio2,
                    R.drawable.cafedelbarrio3,
                    R.drawable.cafedelbarrio4,
                    R.drawable.cafedelbarrio5
                ),
                "Cafetería del Barrio"
            ),
            Cafeteria(
                listOf(
                    R.drawable.cafedoblechocolate1,
                    R.drawable.cafedoblechocolate2,
                    R.drawable.cafedoblechocolate3,
                    R.drawable.cafedoblechocolate4,
                    R.drawable.cafedoblechocolate5
                ),
                "Cafetería Doble Chocolate"
            ),
            Cafeteria(
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

        // Lista para guardar los nombres de las cafeterías "gustadas"
        val listaDeCafeteriasGuardadas = mutableListOf<String>()


        var FotoActual = 0

        // Configura el ViewPagerAdapter inicialmente para la primera cafetería
        viewPager2.adapter = ViewPagerAdapter(cafes[FotoActual].images, cafes[FotoActual].name)

        btnDislike.setOnClickListener {
            FotoActual = (FotoActual + 1) % cafes.size
            viewPager2.adapter = ViewPagerAdapter(cafes[FotoActual].images, cafes[FotoActual].name)
        }

        btnMeLike.setOnClickListener {
            // Añadir el nombre de la cafetería a la lista de gustos
            listaDeCafeteriasGuardadas.add(cafes[FotoActual].name)

            // Cambiar a la siguiente cafetería
            FotoActual = (FotoActual + 1) % cafes.size
            viewPager2.adapter = ViewPagerAdapter(cafes[FotoActual].images, cafes[FotoActual].name)
            Toast.makeText(this, "Cafetería Guardada", Toast.LENGTH_SHORT).show()
        }

        btnMisLikes.setOnClickListener {
            val intent = Intent(this, MisLikesActivity::class.java)
            intent.putStringArrayListExtra("Cafeterías Guardadas.", ArrayList(listaDeCafeteriasGuardadas))
            startActivity(intent)
        }
    }
}
