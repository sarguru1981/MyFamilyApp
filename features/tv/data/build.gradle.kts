import extensions.*

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.ORG_JETBRAINS_KOTLIN)
    id(BuildPlugins.KOTLIN_KAPT)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "API_KEY", "\"480e2dd0113df13a09a661f5c4f370e0\"")
        buildConfigField("String","BASE_URL","\"https://api.themoviedb.org/3/\"")
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = BuildAndroidConfig.JVM_TARGET
    }
}

dependencies {

    implementation(project(BuildModules.Features.TV_DOMAIN_LAYER))

    addBaseDependencies()

    addTestsDependencies()

    addDaggerDependencies()

    addCoroutineAndLifecycleDependencies()

    addRetrofitDependencies()

    addRoomDependencies()
}