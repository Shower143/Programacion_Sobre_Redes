package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buscamos los elementos que ya están creados en activity_main.xml.
        val texto = findViewById<TextView>(R.id.textView2)
        val botonSaludo = findViewById<Button>(R.id.button)
        val botonSiguiente = findViewById<Button>(R.id.button3)

        // Al tocar el botón, cambiamos el texto que aparece en pantalla.
        botonSaludo.setOnClickListener {
            texto.text = "Hola"
        }

        // Abrimos la pantalla del ejercicio 2.
        botonSiguiente.setOnClickListener {
            val pantalla = Intent(this, MainActivity2::class.java)
            startActivity(pantalla)
        }
    }
}
