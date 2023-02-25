package com.example.estudosmvvm

import android.app.Person
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var textWelcome = MutableLiveData<String>()
    private var login = MutableLiveData<Boolean>()
    private val personRepository = PersonRepository()

    init {
        textWelcome.value = "Olá! funcionou!"
    }

    fun welcome(): LiveData<String> {
        return textWelcome
    }

    fun login(): LiveData<Boolean> {
        return login
    }

    fun doLogin(email: String, senha: String) {
        login.value = personRepository.login(email, senha)
    }
}