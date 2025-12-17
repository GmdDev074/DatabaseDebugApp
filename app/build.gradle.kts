plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.zatswahm.database.de.bug.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.zatswahm.database.de.bug.app"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            resValue("string", "PORT_NUMBER", "8080")
            buildConfigField("boolean", "DEBUG_WEB_VIEW", "true")
        }

        release {
            resValue("string", "PORT_NUMBER", "0")
            buildConfigField("boolean", "DEBUG_WEB_VIEW", "false")
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Android Debug Web View
    implementation("com.github.GmdDev074:Database-DEBUG-Loger-Web-View:1.8.1")

    // PaperDB
    implementation("io.github.pilgr:paperdb:2.7.2")
}