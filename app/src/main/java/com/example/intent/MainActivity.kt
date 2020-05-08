package com.example.intent

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var edtPesquisar : EditText
    private lateinit var btnPesquisar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtPesquisar = findViewById<EditText>(R.id.edtPesquisa)
        btnPesquisar = findViewById<Button>(R.id.btnPesquisar)
        btnPesquisar.setOnClickListener(View.OnClickListener { searchWeb(edtPesquisar.text.toString()) })

    }

    fun searchWeb(query: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, query)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
