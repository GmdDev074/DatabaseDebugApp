package com.zatswahm.database.de.bug.app.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.zatswahm.database.de.bug.app.R
import io.paperdb.Paper

class PaperDbActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paper_db)

        val tvData = findViewById<TextView>(R.id.tvPaperData)

        val keys = Paper.book().allKeys

        if (keys.isEmpty()) {
            tvData.text = "No PaperDB data found"
        } else {
            val builder = StringBuilder()
            keys.forEach { key ->
                val value = Paper.book().read<Any>(key)
                builder.append("• ").append(key)
                    .append(" = ").append(value)
                    .append("\n\n")
            }
            tvData.text = builder.toString()
        }
    }
}
