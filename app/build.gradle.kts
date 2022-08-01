plugins {
    id ("com.android.application")
    id ("kotlin-android")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.avr.myfamilyapp"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation (Dependencies.Libs.core_ktx_lib)
    implementation (Dependencies.Libs.appcompact_lib)
    implementation (Dependencies.Libs.android_material_lib)
    implementation (Dependencies.Libs.lifecycle_runtime_ktx_lib)

    // compose
    implementation (Dependencies.Libs.compose_ui_lib)
    implementation (Dependencies.Libs.compose_material_lib)
    implementation (Dependencies.Libs.compose_ui_tool_preview_lib)
    implementation (Dependencies.Libs.activity_compose_lib)

    // test
    testImplementation (Dependencies.Libs.junit_lib)
    androidTestImplementation (Dependencies.Libs.ext_junit_lib)
    androidTestImplementation (Dependencies.Libs.espresso_lib)
    androidTestImplementation (Dependencies.Libs.compose_junit_test_lib)

    debugImplementation (Dependencies.Libs.compose_ui_tool_lib)
    debugImplementation (Dependencies.Libs.compose_ui_test_lib)
}