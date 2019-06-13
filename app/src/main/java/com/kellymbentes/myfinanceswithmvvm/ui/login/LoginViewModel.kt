package com.kellymbentes.myfinanceswithmvvm.ui.login

import androidx.lifecycle.ViewModel
import com.kellymbentes.myfinanceswithmvvm.data.model.FirestoreUser
import com.kellymbentes.myfinanceswithmvvm.data.repository.FirebaseUserRepository

class LoginViewModel (
    private val userRepository: FirebaseUserRepository
) : ViewModel() {

    fun registerUser (user: FirestoreUser, password : String) = userRepository.registerUser(user, password)

    fun makeLogin (email: String, password : String) = userRepository.loginUser(email, password)

}