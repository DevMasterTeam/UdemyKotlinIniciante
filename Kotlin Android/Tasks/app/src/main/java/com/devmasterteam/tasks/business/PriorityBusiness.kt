package com.devmasterteam.tasks.business

import android.content.Context
import com.devmasterteam.tasks.entities.PriorityEntity
import com.devmasterteam.tasks.repository.PriorityRepository

class PriorityBusiness (context: Context) {

    private val mPriorityRepository: PriorityRepository = PriorityRepository.getInstance(context)

    /**
     * Retorna lista de prioridades
     * */
    fun getList(): MutableList<PriorityEntity> = mPriorityRepository.getList()

}