package com.example.rubricatelefonica.data

import androidx.lifecycle.LiveData


class ContattoRepository(private val contattoDao : RubricaDao) {

    val allContatto : LiveData<List<Contatto>> = contattoDao.leggicontatto()

    fun aggiungiContatto(contatto:Contatto){

        contattoDao.aggiungicontatto(contatto)

    }
    fun deleteContatto(contatto: Contatto){
        contattoDao.deleteContatto(contatto)

    }
}