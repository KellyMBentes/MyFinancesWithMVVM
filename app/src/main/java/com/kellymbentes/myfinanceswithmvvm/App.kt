package com.kellymbentes.myfinanceswithmvvm

import android.app.Application
import com.kellymbentes.myfinanceswithmvvm.data.repository.FirebaseUserRepository
import com.kellymbentes.myfinanceswithmvvm.ui.login.LoginViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

class App : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        bind() from provider {FirebaseUserRepository()}
        bind() from provider {LoginViewModelFactory(instance())}
    }
}