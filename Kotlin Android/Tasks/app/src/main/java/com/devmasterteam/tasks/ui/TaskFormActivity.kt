package com.devmasterteam.tasks.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.devmasterteam.tasks.R
import kotlinx.android.synthetic.main.activity_task_form.*
import android.app.DatePickerDialog
import android.widget.DatePicker
import com.devmasterteam.tasks.business.TaskBusiness
import java.text.SimpleDateFormat
import java.util.*
import com.devmasterteam.tasks.constants.TaskConstants
import android.widget.ArrayAdapter
import android.widget.Toast
import com.devmasterteam.tasks.business.PriorityBusiness
import com.devmasterteam.tasks.entities.PriorityEntity
import com.devmasterteam.tasks.entities.TaskEntity
import com.devmasterteam.tasks.infra.SecurityPreferences
import com.devmasterteam.tasks.infra.ValidationException

class TaskFormActivity : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private var SIMPLE_DATE_FORMAT = SimpleDateFormat("dd/MM/yyyy")
    private var mPriorityEntityList: MutableList<PriorityEntity> = mutableListOf()
    private var mPriorityEntityListId: MutableList<Int> = mutableListOf()
    private var mTaskId: Int = 0
    private lateinit var mTaskBusiness: TaskBusiness
    private lateinit var mPriorityBusiness: PriorityBusiness
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_form)

        // Inicialização de variáveis
        mTaskBusiness = TaskBusiness(this)
        mPriorityBusiness = PriorityBusiness(this)
        mSecurityPreferences = SecurityPreferences(this)

        // Incializa eventos dos elementos
        setListeners()

        // Carrega valores de prioridades
        loadPriorities()

        // Carrega dados passados para a activity
        loadDataFromActivity()
    }

    /**
     * Trata eventos
     * */
    override fun onClick(view: View) {
        when (view.id) {
            R.id.buttonSave -> {
                handleSave()
            }
            R.id.imageToolbarBack -> {
                super.onBackPressed()
            }
            R.id.buttonDate -> {
                showDateDialog()
            }
        }
    }

    /**
     * Trata evento de seleção de data
     * */
    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val strDate = SIMPLE_DATE_FORMAT.format(calendar.time)
        buttonDate.text = strDate
    }

    /**
     * Carrega prioridades
     */
    private fun loadPriorities() {

        // Lista de prioridades do banco de dados local
        mPriorityEntityList = mPriorityBusiness.getList()

        // Cria uma lista de strings para preenchimento do spinner
        val listPriorities = mPriorityEntityList.map { it.description }

        // Mapeia a lista de Ids das prioridades
        mPriorityEntityListId = mPriorityEntityList.map { it.id }.toMutableList()

        // Cria adapter e usa no elemento
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listPriorities)
        spinnerPriority.adapter = adapter

    }

    /**
     * Salva tarefa
     * */
    private fun handleSave() {

        try {
            val userId: Int = mSecurityPreferences.getStoredString(TaskConstants.KEY.USER_ID).toInt()
            val description: String = editDescription.text.toString()
            val priorityId = mPriorityEntityListId[spinnerPriority.selectedItemPosition]
            val dueDate: String = buttonDate.text.toString()
            val complete: Boolean = checkComplete.isChecked

            // Inicializa entidade
            val task = TaskEntity(mTaskId, userId, priorityId, description, dueDate, complete)

            // Inserção de tarefa
            if (mTaskId == 0) {
                mTaskBusiness.insert(task)
                Toast.makeText(this, getString(R.string.tarefa_incluida_com_sucesso), Toast.LENGTH_LONG).show()
            } else {
                mTaskBusiness.update(task)
                Toast.makeText(this, getString(R.string.tarefa_atualizada_com_sucesso), Toast.LENGTH_LONG).show()
            }

            // Finaliza formulário
            finish()

        } catch (e: ValidationException) {
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }

    /**
     * Obtém o indexo do valor carregado
     */
    private fun getIndex(priorityId: Int): Int {
        var index = 0
        for (i in 0..mPriorityEntityList.size) {
            if (mPriorityEntityList[i].id == priorityId) {
                index = i
                break
            }
        }
        return index
    }

    /**
     * Carrega dados de edição
     */
    private fun loadDataFromActivity() {
        val bundle = intent.extras
        if (bundle != null) {
            this.mTaskId = bundle.getInt(TaskConstants.BUNDLE.TASKID, 0)

            // Carrega tarefa
            if (mTaskId != 0) {
                textToolbar.setText(R.string.atualizar_tarefa)
                buttonSave.setText(R.string.atualizar_tarefa_button)

                // Carrega tarefa
                val task = mTaskBusiness.get(mTaskId)

                // Atribui valores as propriedades
                editDescription.setText(task?.description)
                buttonDate.text = task?.dueDate
                if (task != null) {
                    checkComplete.isChecked = task.complete
                    spinnerPriority.setSelection(getIndex(task.priorityId))
                }
            }

        }
    }

    /**
     * Mostra datepicker de seleção
     */
    private fun showDateDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, this, year, month, day).show()
    }

    /**
     * Atribui eventos aos elementos
     * */
    private fun setListeners() {
        buttonDate.setOnClickListener(this)
        buttonSave.setOnClickListener(this)
        imageToolbarBack.setOnClickListener(this)
    }

}