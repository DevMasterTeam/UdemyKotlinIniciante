package com.devmasterteam.tasks.repository

import android.content.Context
import android.database.Cursor
import com.devmasterteam.tasks.constants.DataBaseConstants
import com.devmasterteam.tasks.entities.PriorityEntity
import com.devmasterteam.tasks.repository.helper.TaskDataBaseHelper

/**
 * Classe com construtor privado, impede que seja instanciada
 * Classe de acesso a dados para Prioridades
 * */
class PriorityRepository private constructor (context: Context) {

    private var mUltraTaskDataBaseHelper: TaskDataBaseHelper = TaskDataBaseHelper(context)

    companion object {

        fun getInstance(context: Context) : PriorityRepository {
            if (INSTANCE == null) {
                INSTANCE = PriorityRepository(context)
            }
            return INSTANCE as PriorityRepository
        }

        private var INSTANCE: PriorityRepository? = null

    }

    /**
     * Carrega todos os prioridades
     */
    fun getList(): MutableList<PriorityEntity> {
        val list = mutableListOf<PriorityEntity>()

        try {
            val cursor: Cursor
            val db = this.mUltraTaskDataBaseHelper.readableDatabase

            // Lista de prioridades
            cursor = db.rawQuery("select * from ${DataBaseConstants.PRIORITY.TABLE_NAME}", null)
            if (cursor.count > 0) {
                while (cursor.moveToNext()) {

                    val id = cursor.getInt(cursor.getColumnIndexOrThrow(DataBaseConstants.PRIORITY.COLUMNS.ID))
                    val description = cursor.getString(cursor.getColumnIndexOrThrow(DataBaseConstants.PRIORITY.COLUMNS.DESCRIPTION))

                    // Instancia classe de prioridade
                    val guestEntity = PriorityEntity(id, description)

                    // Adiciona item a lista
                    list.add(guestEntity)
                }
            }

            // Fecha cursor
            cursor.close()

        } catch (e: Exception) {
            return list
        }

        // Retorno objeto com dados
        return list
    }

}