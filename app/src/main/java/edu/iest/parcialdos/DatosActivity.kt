package edu.iest.parcialdos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class DatosActivity : AppCompatActivity() {

    private lateinit var tvTitulo : TextView
    private lateinit var etDueno : EditText
    private lateinit var etGato : EditText
    private lateinit var etEdadGato : EditText

    private val DUENO_KEY = "dueño"
    private val GATO_KEY = "gato"
    private val EDADGATO_KEY = "edad_gato"


    private var dueno: String = ""
    private var gato: String = ""
    private var edad: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        tvTitulo = findViewById(R.id.tvTitulo)
        etDueno = findViewById(R.id.etDueno)
        etGato = findViewById(R.id.etGato)
        etEdadGato = findViewById(R.id.etEdadGato)

        val fabDatos = findViewById<FloatingActionButton>(R.id.fabGuardar)

        fabDatos.setOnClickListener{
            dueno = etDueno.text.toString()
            gato = etGato.text.toString()
            edad = Integer.valueOf(etEdadGato.text.toString())

            val preferencias = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            val editor = preferencias.edit()
            editor.putString(DUENO_KEY,dueno)
            editor.putString(GATO_KEY,gato)
            editor.putInt(EDADGATO_KEY,edad)
            editor.apply()
            Toast.makeText(this, "Se guardaron las preferencias", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("PREFERENCIAS", "onSaveInstanceState")
        // dentro de este metodo significa que se guarda este valor con este nombre y de esta manera
        outState.putString(DUENO_KEY, dueno )
        outState?.run {
            putString(DUENO_KEY, dueno)
            putString(GATO_KEY, gato)
            putInt(EDADGATO_KEY, edad)
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)

    }

    override fun onResume() {
        Log.d("PREFERENCIAS", "onResume")


        if(TextUtils.isEmpty(dueno)){
            Log.d("ENTRO","aqui")
            val preferencias = getSharedPreferences("PERSISTENCIA", MODE_PRIVATE)
            dueno = preferencias.getString(DUENO_KEY, "").toString()
            gato = preferencias.getString(GATO_KEY, "").toString()
            edad = preferencias.getInt(EDADGATO_KEY, 0)
        }

        tvTitulo.setText("Con Datos Previamente Guardados")
        etDueno.setText(dueno)
        etGato.setText(gato)
        etEdadGato.setText(edad.toString())

        super.onResume()
    }

    override fun onStart() {
        Log.d("PREFERENCIAS", "onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d("PREFERENCIAS", "onPause")
        super.onPause()
    }

    override fun onDestroy() {
        Log.d("PREFERENCIAS", "onDestroy")
        super.onDestroy()
    }
}