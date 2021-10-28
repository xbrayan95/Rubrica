package com.example.rubricatelefonica.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "contatti")
data class Contatto  (val nome: String,
                      val cognome:String,
                      val numero: String,
                      val email:String){

    @PrimaryKey(autoGenerate = true) var id:Int = 0
}

