package dependency

import BuildDependencyVersions

object Dependencies {
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
}