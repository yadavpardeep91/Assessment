plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //alias( libs.plugins.kotlinKapt)
    //alias(libs.plugins.daggerHiltAndroidPlugin)
   // id(libs.plugins.kotlinKapt.get().pluginId) apply false
    //id(libs.plugins.daggerHiltAndroidPlugin.get().pluginId) apply false
}

android {
    namespace = "com.pardeep.assisment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pardeep.assisment"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            buildConfigField("String", "API_BASE_URL", "\"https://dog.ceo/api/\"")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            buildConfigField("String", "API_BASE_URL", "\"https://dog.ceo/api/\"")

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
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.hilt.android)
    implementation(libs.hilt.lifecycle.viewmodel)
    implementation(libs.activity.ktx)
    implementation(libs.lifecycle.runtime.ktx)


}