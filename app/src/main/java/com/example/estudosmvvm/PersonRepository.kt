package com.example.estudosmvvm

class PersonRepository {

    fun login(email: String, senha: String) : Boolean {
        return email != "" && senha != ""
    }

}