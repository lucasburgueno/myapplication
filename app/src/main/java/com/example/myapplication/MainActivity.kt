package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var listView: ListView
    private lateinit var button: Button

    private var paisSeleccionado: String? = null

    private val colombia =
        listOf("Atlético Junior", "Independiente Santa Fe", "Once Caldas", "Cúcuta Deportivo", "La Equidad")
    private val argentina =
        listOf("Vélez Sarsfield", "Huracán", "Argentinos Juniors", "Newell's Old Boys", "Gimnasia La Plata")
    private val uruguay =
        listOf("Wanderers", "River Plate (Uruguay)", "Central Español", "Racing Club (Uruguay)", "Fénix")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)
        listView = findViewById(R.id.listView)
        button = findViewById(R.id.button)

        val paises = listOf("Colombia", "Argentina", "Uruguay")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, paises)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                paisSeleccionado = paises[position]
                val equipos = when (paisSeleccionado) {
                    "Colombia" -> colombia
                    "Argentina" -> argentina
                    "Uruguay" -> uruguay
                    else -> emptyList()
                }

                val adapterListView =
                    ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, equipos)
                listView.adapter = adapterListView
                adapter.notifyDataSetChanged()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}