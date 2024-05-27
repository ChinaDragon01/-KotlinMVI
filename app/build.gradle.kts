import org.jetbrains.kotlin.gradle.plugin.extraProperties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.kotlinmvi"
    compileSdk = rootProject.extra["compileSdk"] as Int
    /*
      报错信息
      1.  Dependency 'androidx.activity:activity:1.8.0' requires libraries and applications that
      depend on it to compile against version 34 or later of the
      Android APIs.


      :app is currently compiled against android-33.

      Recommended action: Update this project to use a newer compileSdk
      of at least 34, for example 34.

      解决方法链接：https://blog.csdn.net/g984160547/article/details/134533886


      androidx.activity:activity:1.8.0 在material里

      或者降低版本 implementation "com.google.android.material:material:1.8.0"


     */

    defaultConfig {
        applicationId = "com.example.kotlinmvi"
        minSdk = rootProject.extra["minSdk"] as Int
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.bundles.junitTest)
    implementation(project(":baselib"))
}