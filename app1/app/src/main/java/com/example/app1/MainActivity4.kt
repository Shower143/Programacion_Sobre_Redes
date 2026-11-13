package com.example.app1

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity(), SensorEventListener {

    private lateinit var administradorSensores: SensorManager
    private lateinit var textoLuz: TextView
    private lateinit var textoAcelerometro: TextView
    private lateinit var textoGiroscopio: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        // Buscamos los textos donde vamos a mostrar las mediciones.
        textoLuz = findViewById(R.id.textView9)
        textoAcelerometro = findViewById(R.id.textView10)
        textoGiroscopio = findViewById(R.id.textView11)

        // Android nos da acceso a los sensores del celular.
        administradorSensores = getSystemService(SENSOR_SERVICE) as SensorManager

        // Comprobamos si el celular tiene los tres sensores.
        if (administradorSensores.getDefaultSensor(Sensor.TYPE_LIGHT) == null) {
            textoLuz.text = "Sensor no disponible"
        }
        if (administradorSensores.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) == null) {
            textoAcelerometro.text = "Sensor no disponible"
        }
        if (administradorSensores.getDefaultSensor(Sensor.TYPE_GYROSCOPE) == null) {
            textoGiroscopio.text = "Sensor no disponible"
        }

        // Botón para volver al ejercicio de inicio de sesión.
        val botonVolver = findViewById<Button>(R.id.buttonej3)
        botonVolver.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }
    }

    // Esta función se ejecuta cuando Android informa un cambio en un sensor.
    override fun onSensorChanged(evento: SensorEvent) {
        when (evento.sensor.type) {
            Sensor.TYPE_LIGHT -> {
                // values[0] contiene la luz medida en lux.
                textoLuz.text = "${evento.values[0]} lx"
            }

            Sensor.TYPE_ACCELEROMETER -> {
                // El acelerómetro informa el movimiento en los tres ejes.
                textoAcelerometro.text = "X: ${evento.values[0]}\nY: ${evento.values[1]}\nZ: ${evento.values[2]} m/s²"
            }

            Sensor.TYPE_GYROSCOPE -> {
                // El giroscopio informa el giro en los tres ejes.
                textoGiroscopio.text = "X: ${evento.values[0]}\nY: ${evento.values[1]}\nZ: ${evento.values[2]} rad/s"
            }
        }
    }

    // No necesitamos hacer nada cuando cambia la precisión del sensor.
    override fun onAccuracyChanged(sensor: Sensor?, precision: Int) {
    }

    // Cuando la pantalla aparece, activamos los sensores disponibles.
    override fun onResume() {
        super.onResume()

        val luz = administradorSensores.getDefaultSensor(Sensor.TYPE_LIGHT)
        val acelerometro = administradorSensores.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val giroscopio = administradorSensores.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        luz?.let { administradorSensores.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
        acelerometro?.let { administradorSensores.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
        giroscopio?.let { administradorSensores.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL) }
    }

    // Cuando salimos de la pantalla, apagamos la escucha para ahorrar batería.
    override fun onPause() {
        super.onPause()
        administradorSensores.unregisterListener(this)
    }
}
