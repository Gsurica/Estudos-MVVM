package com.example.estudosmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.estudosmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setEventListeners()
        setObserver()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.successButton) {
            handleLogin()
        }
    }

    private fun handleLogin() {
        val email = binding.editTextOne.text.toString()
        val senha = binding.editTextTwo.text.toString()

        viewModel.doLogin(email, senha)
    }

    private fun setEventListeners() {
        binding.successButton.setOnClickListener(this)
    }

    private fun setObserver() {
        welcomeTextObserver()
        loginObeserver()
    }

    private fun welcomeTextObserver() {
        viewModel.welcome().observe(this, {
            binding.textWelcome.text = it
        })
    }

    private fun loginObeserver() {
        viewModel.login().observe(this, {
            if (it) {
                Toast.makeText(this, "SUCESSO!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "FALHA!!", Toast.LENGTH_LONG).show()
            }
        })
    }


}