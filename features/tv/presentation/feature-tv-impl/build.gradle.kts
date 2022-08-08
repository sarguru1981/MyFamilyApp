import dependency.Dependencies
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

    implementation(project(BuildModules.Features.BASE_API))
    implementation(project(BuildModules.Features.TV_API))
    implementation(project(BuildModules.Features.TV_DOMAIN_LAYER))

    addBaseDependencies()

    addDependenciesForCompose()

    implementation (Dependencies.COMPOSE_UI_TOOL)

    implementation (Dependencies.RATING_BAR)

    implementation (Dependencies.COIL)

    implementation (Dependencies.SYSTEM_UI)

    implementation (Dependencies.FLOW_LAYOUT)

    implementation (Dependencies.COMPOSE_UI_UTIL)

    addTestsDependencies()

    addDaggerDependencies()

    addCoroutineAndLifecycleDependencies()
}