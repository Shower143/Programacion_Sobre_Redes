package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3_1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main31)

        // Buscamos la imagen que aparece en esta pantalla.
        val imagen = findViewById<ImageView>(R.id.imageView)

        // Al tocar la imagen, volvemos a la pantalla de inicio de sesión.
        imagen.setOnClickListener {
            val volverAlLogin = Intent(this, MainActivity3::class.java)
            startActivity(volverAlLogin)
            finish() // Cerramos esta pantalla para no dejarla abierta.
        }
    }
}
