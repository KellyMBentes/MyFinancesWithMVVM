package com.kellymbentes.myfinanceswithmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kellymbentes.myfinanceswithmvvm.R
import com.kellymbentes.myfinanceswithmvvm.data.model.FirestoreUser
import com.kellymbentes.myfinanceswithmvvm.data.repository.FirebaseUserRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
