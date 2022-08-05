import extensions.addDebugDependencies
import extensions.addTestsDependencies
import dependency.Dependencies

plugins {
    id (BuildPlugins.ANDROID_APPLICATION)
    id (BuildPlugins.KOTLIN_ANDROID)
    id (BuildPlugins.ORG_JETBRAINS_KOTLIN)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables.useSupportLibrary = BuildAndroidConfig.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        testInstrumentationRunnerArguments.putAll(BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER_ARGUMENTS)

        buildConfigField("String", "API_KEY", "\"480e2dd0113df13a09a661f5c4f370e0\"")
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
        }

        getByName(BuildType.DEBUG) {
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled
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
        kotlinCompilerExtensionVersion = BuildDependencyVersions.compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    dynamicFeatures.addAll(
        setOf(BuildModules.Features.MOVIE,
        )
    )
}

dependencies {
    implementation (Dependencies.CORE_KTX)
    implementation (Dependencies.APP_COMPACT)
    implementation (Dependencies.MATERIAL)
    implementation (Dependencies.LIFECYCLE_RUNTIME)

    // compose
    implementation (Dependencies.COMPOSE_UI)
    implementation (Dependencies.COMPOSE_MATERIAL)
    implementation (Dependencies.COMPOSE_UI_TOOL)
    implementation (Dependencies.ACTIVITY_COMPOSE)

    // test
    addTestsDependencies()

    addDebugDependencies()

    // navigation
    implementation (Dependencies.COMPOSE_NAVIGATION)
    implementation (Dependencies.ACCOMPANIST)
}