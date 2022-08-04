// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id (BuildPlugins.ANDROID_APPLICATION) version (BuildDependencyVersions.gradle_version) apply false
    id (BuildPlugins.ANDROID_LIBRARY) version (BuildDependencyVersions.gradle_version) apply false
    id (BuildPlugins.ORG_JETBRAINS_KOTLIN) version (BuildDependencyVersions.kotlin_compile_version) apply false
    id (BuildPlugins.ANDROID_DYNAMIC_FEATURE) version (BuildDependencyVersions.gradle_version) apply false
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}