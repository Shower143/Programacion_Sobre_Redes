package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Datos que vamos a aceptar como usuario y contraseña.
        val usuarioCorrecto = "hola"
        val claveCorrecta = "1234"

        // Conectamos los campos y botones de la pantalla.
        val campoUsuario = findViewById<EditText>(R.id.editTextText)
        val campoClave = findViewById<EditText>(R.id.editTextTextPassword)
        val botonValidar = findViewById<Button>(R.id.button7)
        val mensaje = findViewById<TextView>(R.id.textView3)
        val botonVolver = findViewById<Button>(R.id.button6)
        val botonSensores = findViewById<Button>(R.id.button8)

        // Comparamos lo que escribió la persona con los datos correctos.
        botonValidar.setOnClickListener {
            val usuarioIngresado = campoUsuario.text.toString().trim()
            val claveIngresada = campoClave.text.toString()

            if (usuarioIngresado == usuarioCorrecto && claveIngresada == claveCorrecta) {
                mensaje.text = "Usuario y contraseña correctos. ¡Hola $usuarioIngresado!"
            } else {
                // Si los datos no coinciden, abrimos la pantalla que tiene una imagen.
                val pantallaError = Intent(this, MainActivity3_1::class.java)
                startActivity(pantallaError)
            }
        }

        // Volver al ejercicio de suma.
        botonVolver.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        // Abrir la pantalla de los sensores.
        botonSensores.setOnClickListener {
            startActivity(Intent(this, MainActivity4::class.java))
        }
    }
}
