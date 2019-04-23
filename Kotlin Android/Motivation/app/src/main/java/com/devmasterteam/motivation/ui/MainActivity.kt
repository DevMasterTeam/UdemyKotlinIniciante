package com.devmasterteam.motivation.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import com.devmasterteam.motivation.R
import com.devmasterteam.motivation.data.Mock
import com.devmasterteam.motivation.infra.MotivationConstants
import com.devmasterteam.motivation.infra.SecurityPrefences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var filter: Int = MotivationConstants.PHRASE_FILTER.ALL
    private val mMock: Mock = Mock()

    // Inicialização tardia. Variável precisa do contexto para ser inicializada corretamente
    // Acesso ao SharedPreferences
    private lateinit var mSecurityPrefences: SecurityPrefences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove Toolbar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // Inicializa variáveis
        mSecurityPrefences = SecurityPrefences(this)

        // Adiciona eventos
        setListeners()

        // Inicializa
        handleFilter(R.id.imageAll)
        refreshPhrase()
        showUserName()
    }

    /**
     * Trata eventos de click
     * */
    override fun onClick(view: View) {
        val id: Int = view.id

        val listId = listOf(
            R.id.imageAll,
            R.id.imageHappy,
            R.id.imageMorning
        )
        if (id in listId) {
            handleFilter(id)
        } else if (id == R.id.buttonRefresh) {
            refreshPhrase()
        }
    }

    /**
     * Atribui eventos aos elementos
     * */
    private fun setListeners() {
        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)
        buttonRefresh.setOnClickListener(this)
    }

    /**
     * Atualiza frase de motivação
     * */
    private fun refreshPhrase() {
        textPhrase.text = mMock.getPhrase(filter)
    }

    /**
     * Busca o nome do usuário
     * */
    private fun showUserName() {
        val name = mSecurityPrefences.getStoredString(MotivationConstants.KEY.PERSON_NAME)
        textUserName.text = "Olá, $name!"
    }

    /**
     * Trata o filtro aplicado para as frases
     * */
    private fun handleFilter(id: Int) {

        imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
        imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
        imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.white))

        when (id) {
            R.id.imageAll -> {
                filter = MotivationConstants.PHRASE_FILTER.ALL
                imageAll.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
            }
            R.id.imageHappy -> {
                filter = MotivationConstants.PHRASE_FILTER.HAPPY

                // Possível de trocar a fonte da imagem e atribuir ao elemento de layout
                // imageHappy.setImageResource(R.drawable.ic_happy_grey)

                // Possível de trocar a cor do ícone
                imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
            }
            else -> {
                filter = MotivationConstants.PHRASE_FILTER.MORNING
                imageMorning.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent))
            }
        }

    }
}