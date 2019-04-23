package com.devmasterteam.componentes

import android.app.ProgressDialog
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.ArrayAdapter
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.RelativeLayout
import android.widget.ProgressBar



class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener, SeekBar.OnSeekBarChangeListener {

    /**
     * Faz a criação da Activity
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Atribui eventos aos elementos
        setListeners()

        // Carega spinner dinâminco
        loadSpinner()
    }

    /**
     * Trata eventos de click
     * */
    override fun onClick(v: View) {

        // Obtém Id do elemento que disparou o evento
        val id = v.id

        // Verifica se é o elemento que interessa
        if (id == R.id.buttonToastMe) {

            // Toast.makeText(this, "Toast me - hardcode", Toast.LENGTH_SHORT).show()
            val toast = Toast.makeText(this, R.string.toast_me, Toast.LENGTH_LONG)

            // Não deixa as bordas do toast arredondadas
            val view = toast.view
            view.setBackgroundColor(Color.BLACK)

            // Inflamos um layout criado especificamente para a toast
            val inflater: LayoutInflater = layoutInflater
            val toastLayout = inflater.inflate(R.layout.toast_layout, null)
            toast.view = toastLayout

            // Cor do texto
            // val textView = toast.view.findViewById<TextView>(android.R.id.message)
            val textView = toast.view.findViewById<TextView>(R.id.textMessage)
            textView.text = "Custom!"
            textView.setTextColor(Color.YELLOW)

            toast.show()

        } else if (id == R.id.buttonSnackMe) {

            // Snackbar.make(constraintLayout, "Snack - hardcode", Snackbar.LENGTH_LONG).show()
            val snackbar = Snackbar.make(constraintLayout, R.string.snack_me, Snackbar.LENGTH_LONG)
            snackbar.setActionTextColor(Color.BLUE)

            snackbar.setAction("Desfazer!", View.OnClickListener {
                Snackbar.make(constraintLayout, "Message is restored!", Snackbar.LENGTH_SHORT).show()
            })

            // Mudando a cor do plano de fundo
            val sbView = snackbar.view
            sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent))

            // Mudando a cor do texto
            val textView = sbView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
            textView.setTextColor(Color.YELLOW)
            textView.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary))

            // Deprecated
            // resources.getColor(R.color.colorPrimary)

            // Mostra a snack
            snackbar.show()

        } else if (id == R.id.buttonGetSpinner) {

            // Obtém o valor do spinner e converte para String, pois inicial vem como Object.
            val value = spinnerDynamic.selectedItem.toString()
            // val value = spinnerDynamic.selectedItemId
            // val value = spinnerDynamic.selectedItemPosition
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()

        } else if (id == R.id.buttonSetSpinner) {

            // Atribui o valor do spinner de acordo com o ID do elemento
            spinnerDynamic.setSelection(3)

        } else if (id == R.id.buttonProgress) {

            // ProgressDialog - Deprecated
            val progressDialog: ProgressDialog = ProgressDialog(this)
            progressDialog.setTitle("Título")
            progressDialog.setMessage("Message")
            progressDialog.show()

            // Fechar ProgressDialog programaticamente
            // progressDialog.hide()
            // progressDialog.dismiss()

        } else if (id == R.id.buttonGetSeek) {

            // Ontém o valor de um Seekbar
            val progress = seekbarSeek.progress.toString()
            Toast.makeText(this, progress, Toast.LENGTH_LONG).show()

        } else if (id == R.id.buttonSetSeek) {

            // Atribui valor a um Seekbar
            seekbarSeek.progress = 10

        }
    }

    /**
     * Nenhum valor selecionado no Spinner
     * */
    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(this, "NOTHING", Toast.LENGTH_LONG).show()
    }

    /**
     * Trata evento de item selecionado no Spinner
     * */
    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        val value = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
    }

    /**
     * Trata evento de valor alterado no Seekbar
     * */
    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
        // Verifica se Seekbar que chamou o evento é a que nos interessa e mostra alteração de valor
        if (seekbarSeek.id == R.id.seekbarSeek) {
            textSeekValue.text = progress.toString()
        }
    }

    /**
     * Trata evento de toque inicial no Seekbar
     * */
    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    /**
     * Trata evento de toque final no Seekbar
     * */
    override fun onStopTrackingTouch(p0: SeekBar?) {
    }

    /**
     * Carrega spinner dinâmico
     */
    private fun loadSpinner() {

        // Carrega dados
        val list = Mock.spinnerMock()

        // Cria o adapter utilizando layout padrão do Android para Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Atribui o adapter ao spinner
        spinnerDynamic.adapter = adapter

    }

    /**
     * Atribui eventos aos elementos
     */
    private fun setListeners() {
        buttonToastMe.setOnClickListener(this)
        buttonSnackMe.setOnClickListener(this)
        buttonGetSpinner.setOnClickListener(this)
        buttonSetSpinner.setOnClickListener(this)
        buttonProgress.setOnClickListener(this)
        buttonGetSeek.setOnClickListener(this)
        buttonSetSeek.setOnClickListener(this)
        spinnerDynamic.onItemSelectedListener = this
        seekbarSeek.setOnSeekBarChangeListener(this)
    }
}