package com.ida.thread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnHandler.setOnClickListener {
                val intent = Intent(this@MainActivity, HandlerActivity::class.java)
                startActivity(intent)
            }

            btnAsyncTask.setOnClickListener {
                val intent = Intent(this@MainActivity, AsyncTaskActivity::class.java)
                startActivity(intent)
            }

            btnCoroutines.setOnClickListener {
                val intent = Intent(this@MainActivity, CoroutinesActivity::class.java)
                startActivity(intent)
            }
        }

    }
}