package com.ruzzante.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ruzzante.businesscard.data.BusinessCard
import com.ruzzante.businesscard.data.BusinessCardRepository
import java.lang.IllegalArgumentException

class MainViewModel ( private val businessCardRepository: BusinessCardRepository): ViewModel() {

    fun insert(businessCard: BusinessCard) = businessCardRepository.insert(businessCard)

    fun delete(businessCard: BusinessCard) = businessCardRepository.delete(businessCard)

    fun getAll():LiveData<List<BusinessCard>> = businessCardRepository.getAll()

}
// Segundo professor, é um código um pouco chato pois não está sendo feito injeção de dependencia com algum framework e tem que ser feito na "mão"
class MainViewModelFactory(private val repository: BusinessCardRepository):ViewModelProvider.Factory{
    override fun <T: ViewModel?> create (modelClass: Class<T>):T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class - MainViewModel.kt")
    }
}