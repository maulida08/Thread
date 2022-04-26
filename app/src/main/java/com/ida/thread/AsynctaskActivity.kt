package com.ida.thread

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.ida.thread.databinding.ActivityAsynctaskBinding

class AsynctaskActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAsynctaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsynctaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            when {
                binding.etNumber.text.toString().isEmpty() -> {
                    Toast.makeText(this, "Number Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val number = binding.etNumber.text.toString().toInt()
                    StartCount().execute(number)
                }
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    inner class StartCount : AsyncTask<Int, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            binding.linear.visibility = View.VISIBLE
            binding.btnSubmit.isEnabled = false
        }

        override fun doInBackground(vararg number: Int?): String {
            for (i in 1..number[0]!!) {
                publishProgress(i.toString())
            }
            return number[0].toString()
        }

        override fun onProgressUpdate(vararg values: String?) {
            super.onProgressUpdate(*values)
            val nomor = values[0].toString().toInt()
            if (nomor % 1000 == 0) {
                binding.tvMessage.text = "Angka-$nomor"
                Log.d("cek Nomor", nomor.toString())
                val maxNumber = binding.etNumber.text.toString().toInt()
                binding.pbCount.max = maxNumber
                ObjectAnimator.ofInt(binding.pbCount, "progress", values[0]!!.toInt()).setDuration(0)
                    .start()
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            binding.tvMessage.text = "Success"
            binding.btnSubmit.isEnabled = true
        }
    }
}