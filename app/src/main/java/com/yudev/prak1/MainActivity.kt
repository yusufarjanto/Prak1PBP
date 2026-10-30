package com.yudev.prak1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etNama = findViewById<EditText>(R.id.etNama)
        val btnToast = findViewById<Button>(R.id.btnToast)
        val btnForm = findViewById<Button>(R.id.btnForm)
        val btnBrowser = findViewById<Button>(R.id.btnBrowser)

        btnToast.setOnClickListener {
            Toast.makeText(this, "Toast Button Clicked Successfully", Toast.LENGTH_SHORT).show()
        }
        btnForm.setOnClickListener {
            val nama = etNama.text.toString().trim()
            if (nama.isEmpty()) {
                etNama.error = "name required!"
                Toast.makeText(this, "Please Fill in your Name first!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, FormActivity::class.java)
                intent.putExtra("EXTRA_SENDER",nama)
                startActivity(intent)
            }
        }
    }
}