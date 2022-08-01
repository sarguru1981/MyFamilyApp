// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version (Dependencies.Versions.gradle_version) apply false
    id ("com.android.library") version (Dependencies.Versions.gradle_version) apply false
    id ("org.jetbrains.kotlin.android") version (Dependencies.Versions.kotlin_compile_version) apply false
}

tasks.create<Delete>("clean") {
    delete(rootProject.buildDir)
}