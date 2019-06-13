package com.kellymbentes.myfinanceswithmvvm.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.kellymbentes.myfinanceswithmvvm.R

import com.kellymbentes.myfinanceswithmvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*

import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import org.kodein.di.generic.instance


class LoginFragment : BaseFragment(), KodeinAware {

    override val kodein by closestKodein()
    private val viewModelFactory: LoginViewModelFactory by instance()
    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(LoginViewModel::class.java)

        initializeUi()
    }

    private fun initializeUi() {

        btnLogin.setOnClickListener {
            viewModel.makeLogin(edtEmail.text.toString(), edtPassword.text.toString())
        }
    }
}