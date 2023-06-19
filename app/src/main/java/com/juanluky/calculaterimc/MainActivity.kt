package com.juanluky.calculaterimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.juanluky.calculaterimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//      Caixa de alerta
        fun onBackPressed() {
            val builder = AlertDialog.Builder(this)

            builder.setMessage("Preecha os campos vazios.")

            builder.setTitle("Alerta !")

            builder.setCancelable(false)

            builder.setPositiveButton("OK") {
                    dialog, which -> dialog.cancel()
            }
            val alertDialog = builder.create()
            alertDialog.show()
        }

        val peso = binding.inputPesoValue
        val altura = binding.inputAlturaValue

        binding.btnCalcular.setOnClickListener {
            if(peso.text.isNullOrEmpty() || altura.text.isNullOrEmpty()){
                onBackPressed()
            } else {
                val intent = Intent(this, ResultActivity::class.java)

                intent.putExtra("peso", peso.text.toString())
                intent.putExtra("altura", altura.text.toString())

                startActivity(intent)
                peso.setText("")
                altura.setText("")
            }
        }

    }
}