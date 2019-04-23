package com.devmasterteam.tasks.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.devmasterteam.tasks.R
import com.devmasterteam.tasks.business.UserBusiness
import kotlinx.android.synthetic.main.activity_register.*
import android.content.Intent
import com.devmasterteam.tasks.infra.ValidationException

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mUserBusiness: UserBusiness

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicializa variáveis
        mUserBusiness = UserBusiness(this)

        // Adicona eventos aos elementos
        setListeners()
    }

    /**
     * Trata eventos dos elementos
     * */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.imageToolbarBack -> {
                super.onBackPressed()
            }
            R.id.buttonSave -> {
                handleSave()
            }
        }
    }

    /**
     * Salva usuário
     */
    private fun handleSave() {
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()
        val name = editName.text.toString()

        try {

            // Salva o usuário e salva as informacões
            mUserBusiness.save(name, email, password)

            // Abre a tela principal
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } catch (e: ValidationException) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            Toast.makeText(this, getString(R.string.erro_inesperado), Toast.LENGTH_LONG).show()
        }
    }

    /**
     * Adicona eventos aos elementos
     * */
    private fun setListeners() {
        imageToolbarBack.setOnClickListener(this)
        buttonSave.setOnClickListener(this)
    }
}