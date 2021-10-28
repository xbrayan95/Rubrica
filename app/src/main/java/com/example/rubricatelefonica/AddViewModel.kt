package com.example.rubricatelefonica

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.rubricatelefonica.data.ContattiDatabase
import com.example.rubricatelefonica.data.Contatto
import com.example.rubricatelefonica.data.ContattoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class addViewModel(application: Application) : AndroidViewModel(application) {

    val leggiContatti:LiveData<List<Contatto>>
    private val repository: ContattoRepository
    init {
        val contattoDao=ContattiDatabase.getInstance(application).getRubricaDao()
        repository=ContattoRepository(contattoDao)
        leggiContatti=repository.allContatto
    }
    fun addContatto(contatto: Contatto){
        viewModelScope.launch(Dispatchers.IO){
            repository.aggiungiContatto(contatto)

        }
    }
    fun deleteContatto(contatto: Contatto){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteContatto(contatto)
        }
    }
}