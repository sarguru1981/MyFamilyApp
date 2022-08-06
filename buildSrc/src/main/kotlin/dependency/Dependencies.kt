package dependency

import BuildDependencyVersions

object Dependencies {

    const val hilt_gradle_plugin = "com.google.dagger:hilt-android-gradle-plugin:${BuildDependencyVersions.hilt_version}"

    const val  CORE_KTX = "androidx.core:core-ktx:${BuildDependencyVersions.core_ktx_version}"
    const val  APP_COMPACT = "androidx.appcompat:appcompat:${BuildDependencyVersions.appcompat_version}"
    const val  MATERIAL =
        "com.google.android.material:material:${BuildDependencyVersions.android_material_version}"
    const val  COMPOSE_UI = "androidx.compose.ui:ui:${BuildDependencyVersions.compose_version}"
    const val  COMPOSE_MATERIAL = "androidx.compose.material:material:${BuildDependencyVersions.compose_version}"
    const val  COMPOSE_UI_TOOL =
        "androidx.compose.ui:ui-tooling-preview:${BuildDependencyVersions.compose_version}"
    const val  LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime-ktx:${BuildDependencyVersions.lifecycle_runtime_ktx_version}"
    const val  ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${BuildDependencyVersions.activity_compose_version}"

    //navigation
    const val  COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${BuildDependencyVersions.compose_navigation_version}"
    const val  ACCOMPANIST = "com.google.accompanist:accompanist-insets:${BuildDependencyVersions.accompanist}"

    //Dagger-Hilt
    const val hilt_lib = "com.google.dagger:hilt-android:${BuildDependencyVersions.hilt_version}"
    const val hilt_android_compiler_lib = "com.google.dagger:hilt-android-compiler:${BuildDependencyVersions.hilt_android_compiler_version}"
    const val hilt_viewmodel_lifecycle_lib = "androidx.hilt:hilt-lifecycle-viewmodel:${BuildDependencyVersions.hilt_viewmodel_lifecycle_version}"
    const val hilt_compiler_lib = "androidx.hilt:hilt-compiler:${BuildDependencyVersions.hilt_compiler_version}"
    const val hilt_navigation_lib = "androidx.hilt:hilt-navigation-compose:${BuildDependencyVersions.hilt_navigation_version}"
}