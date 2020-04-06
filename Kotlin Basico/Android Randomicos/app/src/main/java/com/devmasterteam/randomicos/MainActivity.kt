package com.devmasterteam.randomicos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Style "Theme.AppCompat.Light.NoActionBar" esconde também a status bar e deixa transparente
        // O método abaixo certifica que a Action bar seja escondida
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // Adiciona eventos
        setListeners()
    }

    /**
     * Qualquer evento de click disparado aciona o método
     * */
    override fun onClick(v: View?) {
        val id = v?.id

        // Validação de qual elemento foi clicado
        if (id == R.id.buttonRandom || id == R.id.textRandom) {
            // Atribui o valor randômico
            textRandom.text = random().toString()
        }
    }

    /**
     * Gera número aleatório
     */
    private fun random(): Int {
        // Gera um número aleatório >= ZERO e < 50, o que quer dizer que vamos de 0 até 49, por isso somamos 1
        return Random.nextInt(50) + 1
    }

    /**
     * Atribui eventos aos elementos
     * */
    private fun setListeners() {
        buttonRandom.setOnClickListener(this)
        textRandom.setOnClickListener(this)
    }
}