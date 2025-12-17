package com.zatswahm.database.de.bug.app.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.zatswahm.database.de.bug.app.R

class SharedPrefsActivity : AppCompatActivity() {

    private val PREF_NAME = "debug_prefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_prefs)

        val tvData = findViewById<TextView>(R.id.tvPrefsData)

        val prefs = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val allEntries = prefs.all

        if (allEntries.isEmpty()) {
            tvData.text = "No SharedPreferences data found"
        } else {
            val builder = StringBuilder()
            allEntries.forEach { (key, value) ->
                builder.append("• ").append(key)
                    .append(" = ").append(value)
                    .append("\n\n")
            }
            tvData.text = builder.toString()
        }
    }
}
