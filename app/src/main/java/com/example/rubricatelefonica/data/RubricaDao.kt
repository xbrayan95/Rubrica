package com.example.rubricatelefonica.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RubricaDao {
    @Insert
    fun aggiungicontatto (contatto:Contatto)

    @Query("SELECT * FROM contatti")
    fun leggicontatto(): LiveData<List<Contatto>>

    @Delete
    fun deleteContatto(contatto: Contatto)



}