package com.juanluky.calculaterimc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.juanluky.calculaterimc.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val dados = intent.extras

        val peso = dados?.getString("peso")
        val altura = dados?.getString("altura")

        binding.pesoInformado.text = "Peso informado: $peso"
        binding.alturaInformada.text = "Altura informada: $altura"


        //Diagnóstico

        val pesoNum = peso!!.toDouble()
        val alturaNum = altura!!.toDouble()

        val calc = pesoNum / (alturaNum * alturaNum)
//      Format number two houses decimals

        if (calc <= 18.6) {
            binding.resultado.text = "BAIXO"
        }else if (calc in 18.6..24.9) {
            binding.resultado.text = "NORMAL"
        } else if (calc in 25.0..29.9){
            binding.resultado.text = "SOBREPESO"
        } else {
            binding.resultado.text = "OBESIDADE"
        }

    }
}


