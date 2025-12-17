package com.zatswahm.database.de.bug.app

import android.app.Application
import data.base.de.bug.web.view.DebugView
import io.paperdb.Paper

class DatabaseDebugApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize PaperDB
        Paper.init(this)

        // Ensure at least one key exists
        if (Paper.book().allKeys.isEmpty()) {
            Paper.book().write("welcome_key", "Hello PaperDB")
        }

        // Initialize Debug Web View
        DebugView.init(this)
    }
}