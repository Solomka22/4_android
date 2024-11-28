package com.example.a4_android

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var spinBeer: Spinner
    private lateinit var btnBeer: Button
    private lateinit var tvBeer: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinBeer = findViewById(R.id.spinBeer)
        btnBeer = findViewById(R.id.btnBeer)
        tvBeer = findViewById(R.id.tvBeer)
        btnBeer.setOnClickListener {
            val selectedBeerType = spinBeer.selectedItem.toString()
            val beers = getBeers(selectedBeerType)
            val resultText = if (beers.isNotEmpty()) {
                "Рекомендуемые сорта: ${beers.joinToString(", ")}"
            } else {
                "Нет доступных сортов для выбранного типа."
            }
            tvBeer.text = resultText
        }
    }
    private fun getBeers(selectedBeerType: String): List<String> {
        return when (selectedBeerType) {
            "Пилснер" -> listOf("Budweiser", "Heineken", "Pilsner Urquell")
            "Стаут" -> listOf("Guinness", "Murphy's", "Left Hand Milk Stout")
            "ИПА" -> listOf("Stone IPA", "Lagunitas IPA", "Dogfish Head 60 Minute IPA")
            "Портер" -> listOf("Anchor Porter", "Fuller's London Porter", "Sierra Nevada Porter")
            "Эль" -> listOf("Samuel Adams Boston Lager", "Fat Tire Amber Ale", "Newcastle Brown Ale")
            else -> emptyList()
        }
    }
}