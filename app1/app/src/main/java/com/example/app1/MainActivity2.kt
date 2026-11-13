package com.example.app1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Campos donde se escriben los números.
        val numero1 = findViewById<EditText>(R.id.editTextNumber2)
        val numero2 = findViewById<EditText>(R.id.editTextNumber)

        // Botones y texto del resultado.
        val botonSumar = findViewById<Button>(R.id.button2)
        val resultado = findViewById<TextView>(R.id.textView)
        val botonVolver = findViewById<Button>(R.id.button4)
        val botonSiguiente = findViewById<Button>(R.id.button5)

        // Al tocar Sumar, leemos los dos valores y hacemos la cuenta.
        botonSumar.setOnClickListener {
            val textoNumero1 = numero1.text.toString()
            val textoNumero2 = numero2.text.toString()

            // Revisamos que los dos campos tengan algo escrito.
            if (textoNumero1.isNotEmpty() && textoNumero2.isNotEmpty()) {
                val n1 = textoNumero1.toInt()
                val n2 = textoNumero2.toInt()
                val suma = n1 + n2

                // Mostramos el resultado en pantalla.
                resultado.text = suma.toString()
            } else {
                resultado.text = "Ingresá los dos números"
            }
        }

        // Volver al primer ejercicio.
        botonVolver.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // Ir al ejercicio de inicio de sesión.
        botonSiguiente.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }
    }
}
