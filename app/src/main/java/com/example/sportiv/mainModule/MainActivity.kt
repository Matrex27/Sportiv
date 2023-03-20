package com.example.sportiv.mainModule

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.sportiv.databinding.ActivityMainBinding
import kotlinx.coroutines.coroutineScope

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        GetAllResultsTest()
    }


    private fun GetAllResultsTest(){
        lateinit var viewModel: mainViewModel

        viewModel = ViewModelProvider(this)[mainViewModel::class.java]

        viewModel.getAllResults("2023-03-19", "5XrLLn7kKwNXD172")

        viewModel.getResult().observe(this){
            println(it.body()!!.message)
            println(it.body()!!.data)
        }



    }
}