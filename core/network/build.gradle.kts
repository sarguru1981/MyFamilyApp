import extensions.*
import org.gradle.kotlin.dsl.implementation

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION

        buildConfigField("String", "API_KEY", "\"480e2dd0113df13a09a661f5c4f370e0\"")
        buildConfigField("String","BASE_URL","\"https://api.themoviedb.org/3/\"")
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

    implementation(dependency.Dependencies.CORE_KTX)

    addTestsDependencies()

    addDaggerDependencies()

    addRXDependencies()

    addRetrofitDependencies()
}