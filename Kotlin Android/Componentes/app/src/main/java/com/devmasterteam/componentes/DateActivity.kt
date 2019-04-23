package com.devmasterteam.componentes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.app.DatePickerDialog
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*
import android.widget.Toast
import android.os.Build
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_date.*

class DateActivity : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener,
    TimePicker.OnTimeChangedListener {

    private var mBrazilLocale = Locale("pt", "BR")
    private val mSimpleDateFormat = SimpleDateFormat("dd/MM/yyyy", mBrazilLocale)

    /**
     * Criação da Activity
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        // Atribui eventos aos elementos
        setListeners()
    }

    /**
     * Atribui eventos aos elementos
     * */
    private fun setListeners() {
        buttonDate.setOnClickListener(this)
        buttonGetTime.setOnClickListener(this)
        buttonSetTime.setOnClickListener(this)
        timePicker.setOnTimeChangedListener(this)
    }

    /**
     * Trata eventos de click
     * */
    override fun onClick(view: View) {

        // Obtém Id do elemento que disparou o evento
        val id = view.id

        // Verifica se é o elemento que interessa
        if (id == R.id.buttonDate) {
            showDatePickerDialog()
        } else if (id == R.id.buttonGetTime) {

            // Verifica se o SDK atual do dispositivo dá suporte ao novo código
            if (Build.VERSION.SDK_INT >= 23) {

                val hour = timePicker.hour.toString()
                val minute = timePicker.minute.toString()

                val value = "$hour : $minute"
                Toast.makeText(this, value, Toast.LENGTH_LONG).show()

            } else {

                val hour = timePicker.currentHour
                val minute = timePicker.currentMinute

                val value = "$hour : $minute"
                Toast.makeText(this, value, Toast.LENGTH_LONG).show()

            }

        } else if (id == R.id.buttonSetTime) {

            // Verifica se o SDK atual do dispositivo dá suporte ao novo código
            if (Build.VERSION.SDK_INT >= 23) {
                timePicker.hour = 20
                timePicker.minute = 15
            } else {
                timePicker.currentHour = 20
                timePicker.currentMinute = 15
            }

        }
    }

    /**
     * Trata evento de quando um valor no calendário é selecionado
     * */
    override fun onDateSet(datePicker: DatePicker, year: Int, month: Int, dayOfMonth: Int) {

        // Cria um calendário e atribui a data selecionada
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        // Converte a data selecionada para o formato imposto pelo SimpleDateFormat
        val date = mSimpleDateFormat.format(calendar.time)
        buttonDate.text = date
    }

    /**
     * Trata evento de mudança de valor no TimePicker
     * */
    override fun onTimeChanged(timepicker: TimePicker, hourOfDay: Int, minute: Int) {
        Toast.makeText(this, "$hourOfDay:$minute", Toast.LENGTH_SHORT).show()
    }

    /**
     * Mostra seleção de data
     */
    private fun showDatePickerDialog() {

        // Obtém a instância do calendário
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Mostra o Datepicker utilizando os dados de hoje
        DatePickerDialog(this, this, year, month, day).show()
    }
}