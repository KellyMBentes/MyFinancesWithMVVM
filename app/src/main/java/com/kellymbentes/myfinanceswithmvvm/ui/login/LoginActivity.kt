package com.kellymbentes.myfinanceswithmvvm.ui.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.kellymbentes.myfinanceswithmvvm.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.root, LoginFragment(), "loginFragment")
        transaction.addToBackStack("Stack")
        transaction.commit()

    }

}
