# Database Debug App

A simple Android app demonstrating **debugging of SharedPreferences and PaperDB** using [Android Debug Database](https://github.com/amitshekhariitbhu/Android-Debug-Database).

This project allows you to:

* Save and view **SharedPreferences** data.
* Save and view **PaperDB** data.
* Debug both storage mechanisms directly in your browser without rooting your device.

---

## Features

* View all **SharedPreferences** values in a browser.
* View all **PaperDB** values in a browser.
* Add, update, or delete values directly from browser.
* Shows DebugDB URL as a **toast on app launch**.
* Works only in **debug builds**, no effect on release builds.
* Fully written in **Kotlin** with simple XML UI.

---

## Screenshots

**Main Activity:**

* Input SharedPreferences key/value
* Input PaperDB key/value
* Buttons to save or view data

**DebugDB Browser:**

* Shows SharedPreferences under `shared_prefs`
* Shows PaperDB under `Custom Databases`

---

## Setup

### 1. Add dependencies

Add JitPack repository in `settings.gradle`:

```gradle
maven { url 'https://jitpack.io' }
```

Add dependencies in `app/build.gradle`:

```gradle
// Android Debug Database (Debug only)
debugImplementation("com.github.amitshekhariitbhu.Android-Debug-Database:debug-db:1.0.7")

// PaperDB
implementation("io.github.pilgr:paperdb:2.7.2")
```

---

### 2. Application class

Register a custom Application class `DatabaseDebugApp`:

```kotlin
class DatabaseDebugApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
        if (BuildConfig.DEBUG) {
            // Register PaperDB files with DebugDB
        }
    }
}
```

Set it in `AndroidManifest.xml`:

```xml
<application
    android:name=".DatabaseDebugApp"
    ... >
```

---

### 3. Run the app

* Make sure your **Android device or emulator** is on the **same network** as your computer.
* Launch the app (debug variant).
* Look for the DebugDB toast with URL (e.g., `http://192.168.x.x:8080`) and open it in a browser.
* SharedPreferences and PaperDB data will appear in the browser.

---

### 4. Notes

* **PaperDB files** must exist before registering; the app ensures at least one key is written.
* DebugDB is **only included in debug builds**, so release builds remain clean.
* You can also **change the debug port**:

```gradle
debug {
    resValue("string", "PORT_NUMBER", "8080")
}
```

---

### 5. References

* [Android Debug Database GitHub](https://github.com/amitshekhariitbhu/Android-Debug-Database)
* [PaperDB GitHub](https://github.com/pilgr/Paper)

---

### License

```text
Copyright (C) 2024

Licensed under the Apache License, Version 2.0
```
