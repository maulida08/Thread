package com.ida.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ida.thread.databinding.ActivityCoroutinesBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoroutinesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutinesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKenalan.setOnClickListener {
            GlobalScope.launch {
                klik()
            }
        }
    }

    suspend fun klik(){
        delay(2000)
        Log.d("Selamat datang", "Semoga sehat selalu")
    }
}