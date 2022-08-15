import dependency.Dependencies
import extensions.*
import org.gradle.kotlin.dsl.implementation

plugins {
    id (BuildPlugins.ANDROID_APPLICATION)
    id (BuildPlugins.KOTLIN_ANDROID)
    id (BuildPlugins.ORG_JETBRAINS_KOTLIN)
    id (BuildPlugins.KOTLIN_KAPT)
    id (BuildPlugins.HILT_PLUGIN)
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
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildDependencyVersions.compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    dynamicFeatures += setOf(BuildModules.Features.MOVIE)

    /*dynamicFeatures.addAll(
        setOf(BuildModules.Features.MOVIE,BuildModules.Features.MOVIE_IMPL
        )
    )*/
}

dependencies {

    implementation(project(BuildModules.Features.BASE_API))
    implementation(project(BuildModules.Features.DEPENDENCY_PROVIDER))

    implementation(project(BuildModules.Features.HOME_API))
    implementation(project(BuildModules.Features.HOME_API_IMPL))

    implementation(project(BuildModules.Features.TV_API))
    implementation(project(BuildModules.Features.TV_PRESENTATION_LAYER))
    implementation(project(BuildModules.Features.TV_DATA_LAYER))
    implementation(project(BuildModules.Features.TV_DOMAIN_LAYER))

    implementation(project(BuildModules.Features.ARTIST_API))
    implementation(project(BuildModules.Features.ARTIST_PRESENTATION_LAYER))
    implementation(project(BuildModules.Features.ARTIST_DATA_LAYER))
    implementation(project(BuildModules.Features.ARTIST_DOMAIN_LAYER))

    addBaseDependencies()

    implementation (Dependencies.LIFECYCLE_RUNTIME)

    // compose
    addDependenciesForCompose()

    implementation (Dependencies.COMPOSE_UI_TOOL)
    implementation (Dependencies.ACTIVITY_COMPOSE)

    // test
    addTestsDependencies()

    addDebugDependencies()

    // navigation
    implementation (Dependencies.COMPOSE_NAVIGATION)
    implementation (Dependencies.ACCOMPANIST)

    addDaggerDependencies()

    addCoroutineAndLifecycleDependencies()
}