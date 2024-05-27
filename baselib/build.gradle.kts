plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.example.baselib"
    compileSdk = rootProject.extra["compileSdk"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdk"] as Int

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    api(libs.bundles.baseLibs)
    api(libs.glide)
    ksp(libs.glide.compiler)
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.bundles.junitTest)

    api(libs.retrofit)
    api(libs.converterGson)
    api(libs.adapterRxjava3)
    api(libs.gson)
    api(libs.rxjava3)
    api(libs.rxandroid)
    implementation(libs.logging.interceptor)
//    implementation(libs.room)
//    ksp(libs.room.compiler)


}