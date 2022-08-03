plugins {
    id ("com.android.dynamic-feature")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
      minSdk = 21
      testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
       release {
           isMinifyEnabled = false
           proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
       }
    }
    }

dependencies {
    implementation(project(":app"))

    implementation (Dependencies.Libs.core_ktx_lib)
    implementation (Dependencies.Libs.appcompact_lib)
    implementation (Dependencies.Libs.android_material_lib)
    implementation (Dependencies.Libs.lifecycle_runtime_ktx_lib)

    // test
    testImplementation (Dependencies.Libs.junit_lib)
    androidTestImplementation (Dependencies.Libs.ext_junit_lib)
    androidTestImplementation (Dependencies.Libs.espresso_lib)
    androidTestImplementation (Dependencies.Libs.compose_junit_test_lib)
}