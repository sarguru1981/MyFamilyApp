import dependency.Dependencies
import extensions.*
import org.gradle.kotlin.dsl.implementation

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.ORG_JETBRAINS_KOTLIN)
    id (BuildPlugins.HILT_PLUGIN)
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
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        dataBinding = true
    }
}

dependencies {

    implementation(project(BuildModules.Features.BASE_API))
    implementation(project(BuildModules.Features.ARTIST_API))
    implementation(project(BuildModules.Features.ARTIST_DOMAIN_LAYER))

    implementation (Dependencies.CONSTRAINT_LAYOUT)
    implementation (Dependencies.NAVIGATION_FRAGMENT)
    implementation (Dependencies.NAVIGATION_KTX)

    implementation (Dependencies.ACTIVITY_KTX)
    implementation (Dependencies.FRAGMENT_KTX)
    implementation (Dependencies.PICASSO)
    implementation (Dependencies.MULTIDEX)

    implementation (Dependencies.RECYCLERVIEW)
    implementation (Dependencies.GLIDE)
    implementation (Dependencies.LIFECYCLE_EXT)
    implementation (Dependencies.LIFECYCLE_LIVEDATA)
    implementation (Dependencies.LIFECYCLE_VIEWMODEL)
    implementation (Dependencies.LIFECYCLE_VIEWMODEL_SAVEDSTATE)
    implementation (Dependencies.LIFECYCLE_COMMON)

    addBaseDependencies()

    addDependenciesForCompose()

    implementation (Dependencies.COMPOSE_UI_TOOL)

    implementation (Dependencies.RATING_BAR)

    implementation (Dependencies.COIL)

    //implementation (Dependencies.SYSTEM_UI)

    implementation (Dependencies.FLOW_LAYOUT)

    implementation (Dependencies.COMPOSE_UI_UTIL)

    addTestsDependencies()

    addDaggerDependencies()

    addRXDependencies()
}