package com.zatswahm.database.de.bug.app.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zatswahm.database.de.bug.app.R
import io.paperdb.Paper

class MainActivity : AppCompatActivity() {

    private val PREF_NAME = "debug_prefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPrefKey = findViewById<EditText>(R.id.etPrefKey)
        val etPrefValue = findViewById<EditText>(R.id.etPrefValue)
        val btnSavePref = findViewById<Button>(R.id.btnSavePref)

        val etPaperKey = findViewById<EditText>(R.id.etPaperKey)
        val etPaperValue = findViewById<EditText>(R.id.etPaperValue)
        val btnSavePaper = findViewById<Button>(R.id.btnSavePaper)

        val btnViewPrefs = findViewById<Button>(R.id.btnViewPrefs)
        val btnViewPaper = findViewById<Button>(R.id.btnViewPaper)

        btnViewPrefs.setOnClickListener {
            startActivity(Intent(this, SharedPrefsActivity::class.java))
        }

        btnViewPaper.setOnClickListener {
            startActivity(Intent(this, PaperDbActivity::class.java))
        }

        // Save a default value if no PaperDB data exists yet
        if (Paper.book().allKeys.isEmpty()) {
            Paper.book().write("welcome_key", "Hello PaperDB")
        }

        // SharedPreferences Save
        btnSavePref.setOnClickListener {
            val key = etPrefKey.text.toString()
            val value = etPrefValue.text.toString()

            if (key.isBlank()) {
                toast("Key cannot be empty")
                return@setOnClickListener
            }

            val prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE)
            prefs.edit().putString(key, value).apply()

            toast("Saved to SharedPreferences")
        }

        // PaperDB Save
        btnSavePaper.setOnClickListener {
            val key = etPaperKey.text.toString()
            val value = etPaperValue.text.toString()

            if (key.isBlank()) {
                toast("Key cannot be empty")
                return@setOnClickListener
            }

            Paper.book().write(key, value)
            toast("Saved to PaperDB")
        }
    }

    private fun toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}