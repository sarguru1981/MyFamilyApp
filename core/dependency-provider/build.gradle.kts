import extensions.addTestsDependencies
import dependency.Dependencies
import extensions.addAPIDependencies

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
        }
    }
    kotlinOptions {
        jvmTarget = BuildAndroidConfig.JVM_TARGET
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(project(BuildModules.Features.HOME_API))
//    implementation(project(BuildModules.Features.MOVIE))
    implementation(project(BuildModules.Features.TV_API))
    implementation(project(BuildModules.Features.ARTIST_API))

    implementation(Dependencies.CORE_KTX)

    addAPIDependencies()

    addTestsDependencies()
}