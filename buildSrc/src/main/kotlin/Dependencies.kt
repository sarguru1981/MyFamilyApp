class Dependencies {

    object Versions {
        val kotlin_compile_version = "1.6.10"
        val core_ktx_version = "1.8.0"
        val appcompat_version = "1.4.2"
        val android_material_version = "1.6.1"
        val compose_version = "1.1.1"
        val lifecycle_runtime_ktx_version = "2.5.0"
        val activity_compose_version = "1.5.0"

        //testing
        val junit_version = "4.13.2"
        val ext_junit_version = "1.1.3"
        val espresso_version = "3.4.0"

        //navigation
        val compose_navigation_version = "2.4.1"

        val gradle_version = "7.2.1"
    }

    object Libs {

        val core_ktx_lib = "androidx.core:core-ktx:${Versions.core_ktx_version}"
        val appcompact_lib = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
        val android_material_lib =
            "com.google.android.material:material:${Versions.android_material_version}"
        val compose_ui_lib = "androidx.compose.ui:ui:${Versions.compose_version}"
        val compose_material_lib = "androidx.compose.material:material:${Versions.compose_version}"
        val compose_ui_util_lib = "androidx.compose.ui:ui-util:${Versions.compose_version}"
        val compose_ui_tool_preview_lib =
            "androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}"
        val lifecycle_runtime_ktx_lib =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_runtime_ktx_version}"
        val activity_compose_lib = "androidx.activity:activity-compose:${Versions.activity_compose_version}"

        //testing
        val junit_lib = "junit:junit:${Versions.junit_version}"
        val ext_junit_lib = "androidx.test.ext:junit:${Versions.ext_junit_version}"
        val espresso_lib = "androidx.test.espresso:espresso-core:${Versions.espresso_version}"
        val compose_junit_test_lib = "androidx.compose.ui:ui-test-junit4:${Versions.compose_version}"
        val compose_ui_tool_lib =
            "androidx.compose.ui:ui-tooling:${Versions.compose_version}"

        val compose_ui_test_lib = "androidx.compose.ui:ui-test-manifest:${Versions.compose_version}"

        //navigation
        val compose_navigation_lib = "androidx.navigation:navigation-compose:${Versions.compose_navigation_version}"

    }
}