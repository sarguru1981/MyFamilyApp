import dependency.Dependencies
import extensions.addBaseDependencies
import extensions.addDaggerDependencies
import extensions.addDependenciesForCompose
import extensions.addTestsDependencies

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

    api(project(BuildModules.Features.BASE_API))

    addBaseDependencies()

    addDependenciesForCompose()

    implementation (Dependencies.COMPOSE_UI_TOOL)

    addTestsDependencies()

    addDaggerDependencies()
}