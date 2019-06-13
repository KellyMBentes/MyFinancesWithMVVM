package com.kellymbentes.myfinanceswithmvvm.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kellymbentes.myfinanceswithmvvm.data.repository.FirebaseUserRepository

class LoginViewModelFactory (private val userRepository: FirebaseUserRepository)
    : ViewModelProvider.NewInstanceFactory () {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(userRepository) as T
    }
}