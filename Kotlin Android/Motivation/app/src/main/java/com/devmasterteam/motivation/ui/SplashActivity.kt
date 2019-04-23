package com.devmasterteam.motivation.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devmasterteam.motivation.R
import com.devmasterteam.motivation.infra.MotivationConstants
import com.devmasterteam.motivation.infra.SecurityPrefences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    // Inicialização tardia. Variável precisa do valor do contexto para ser inicializada corretamente
    // Acesso ao SharedPreferences
    private lateinit var mSecurityPreferences: SecurityPrefences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Remove Toolbar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // Inicializa variáveis da classe
        mSecurityPreferences = SecurityPrefences(this)

        // Adiciona eventos de click
        buttonSave.setOnClickListener(this)
        verifyUserName()
    }

    /**
     * Tratamento de clicks dos elementos
     * */
    override fun onClick(view: View?) {
        val id: Int? = view?.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    /**
     * Verifica se usuário já preencheu o nome
     * */
    private fun verifyUserName() {
        val name = mSecurityPreferences.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        if (name != "") {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    /**
     * Salva o nome do usuário para utilizações futuras
     * */
    private fun handleSave() {

        // Obtém o nome
        val name: String = editName.text.toString()

        // Verifica se usuário preencheu o nome
        if (name == "") {
            Toast.makeText(this, "Informe seu nome.", Toast.LENGTH_LONG).show()
        } else {

            // Salva os dados do usuário e redireciona para as frases
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))

            // Impede que seja possível voltar a Activity
            finish()
        }
    }
}