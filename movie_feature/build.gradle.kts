import extensions.addTestsDependencies
import dependency.Dependencies

plugins {
    id(BuildPlugins.ANDROID_DYNAMIC_FEATURE)
    id(BuildPlugins.ORG_JETBRAINS_KOTLIN)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName(BuildType.RELEASE){
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled
        }
    }
}

dependencies {
    implementation(project(BuildModules.APP))

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APP_COMPACT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.LIFECYCLE_RUNTIME)

    // test
    addTestsDependencies()
}