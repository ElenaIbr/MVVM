package com.ibraeva.mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ibraeva.data.repository.UserRepositoryImpl
import com.ibraeva.data.storage.SharedPrefUserStorage
import com.ibraeva.mvvm.databinding.ActivityMainBinding
import com.ibraeva.domain.models.SaveUsername
import com.ibraeva.domain.usercases.GetUsernameUseCase
import com.ibraeva.domain.usercases.SaveUsernameUseCase

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mViewModel = ViewModelProvider(this, MainViewModelFactory(this))
                .get(MainViewModel::class.java)

        mViewModel.resultLive.observe(this, Observer {
            mBinding.dataTV.text = it
        })

        mBinding.sendData.setOnClickListener {
            val text = mBinding.dataET.text.toString()
            mViewModel.save(text)
        }

        mBinding.receiveData.setOnClickListener {
            mViewModel.load()
        }

    }
}