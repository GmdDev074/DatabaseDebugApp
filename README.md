# Database Debug App

A simple Android app demonstrating **debugging of SharedPreferences and PaperDB** using [Android Debug Web View](https://github.com/GmdDev074/Database-DEBUG-Loger-Web-View).

This project allows you to:

* Save and view **SharedPreferences** data.
* Save and view **PaperDB** data.
* Debug both storage mechanisms directly in your browser without rooting your device.

---

## Features

* Web-based **dashboard** to view SharedPreferences and PaperDB data.
* Real-time updates (planned functionality).
* Zero configuration: works out of the box with a single line of code.
* Works only in **debug builds**, no effect on release builds.
* Fully written in **Kotlin** with simple XML UI.

---

## Screenshots

**Main Activity:**

* Input SharedPreferences key/value
* Input PaperDB key/value
* Buttons to save or view data

**Web Dashboard:**

* Shows SharedPreferences under `shared_prefs`
* Shows PaperDB under `Custom Databases`
* Accessible via URL shown in Logcat (e.g., `http://192.168.x.x:8080/index.html`)

---

## Setup

### 1. Add dependencies

Add JitPack repository in `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

```agsl
dependencies {
    implementation("com.github.GmdDev074:Database-DEBUG-Loger-Web-View:1.0.0")
}
```

```agsl
import android.app.Application
import data.base.de.bug.web.view.DebugView
import io.paperdb.Paper

class DatabaseDebugApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
        if (BuildConfig.DEBUG) {
            // Initialize Debug Web View
            DebugView.init(this)
        }
    }
}
```
```agsl
<application
    android:name=".DatabaseDebugApp"
    ... >
```
```agsl
<uses-permission android:name="android.permission.INTERNET"/>
```
