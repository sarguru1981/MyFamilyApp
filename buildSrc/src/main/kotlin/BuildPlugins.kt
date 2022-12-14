/**
 * Configuration of all gradle build plugins
 */
object BuildPlugins {
    const val ANDROID_APPLICATION = "com.android.application"
    const val ANDROID_DYNAMIC_FEATURE = "com.android.dynamic-feature"
    const val ANDROID_LIBRARY = "com.android.library"
    const val HILT_PLUGIN = "dagger.hilt.android.plugin"

    const val NAVIGATION_PLUGIN = "androidx.navigation.safeargs"

    const val KOTLIN_ANDROID = "kotlin-android"
    const val KOTLIN_KAPT = "kotlin-kapt"

    const val ORG_JETBRAINS_KOTLIN = "org.jetbrains.kotlin.android"
}