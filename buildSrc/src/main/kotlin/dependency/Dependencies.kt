package dependency

import BuildDependencyVersions

object Dependencies {

    const val HILT_GRADLE_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${BuildDependencyVersions.hilt_version}"

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
    const val HILT_LIB = "com.google.dagger:hilt-android:${BuildDependencyVersions.hilt_version}"
    const val HILT_ANDROID_COMPILER = "com.google.dagger:hilt-android-compiler:${BuildDependencyVersions.hilt_android_compiler_version}"
    const val HILT_VIEWMODEL_LIFECYCLE = "androidx.hilt:hilt-lifecycle-viewmodel:${BuildDependencyVersions.hilt_viewmodel_lifecycle_version}"
    const val HILT_COMPILER = "androidx.hilt:hilt-compiler:${BuildDependencyVersions.hilt_compiler_version}"
    const val HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:${BuildDependencyVersions.hilt_navigation_version}"

    //Corourtines
    const val COROUTINE_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${BuildDependencyVersions.coroutine_version}"
    const val COROUTINE_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${BuildDependencyVersions.coroutine_version}"
    const val COROUTINE_PLAY_SERVICE = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${BuildDependencyVersions.coroutine_version}"
    const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${BuildDependencyVersions.coroutine_lifecycle_version}"

    // flow layout
    const val FLOW_LAYOUT = "com.google.accompanist:accompanist-flowlayout:${BuildDependencyVersions.flow_layout_version}"

    // Room
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${BuildDependencyVersions.room_version}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${BuildDependencyVersions.room_version}"
    const val ROOM = "androidx.room:room-ktx:${BuildDependencyVersions.room_version}"
    const val ROOM_PAGING = "androidx.room:room-paging:${BuildDependencyVersions.room_paginating_version}"
    const val ROOM_COMMON = "androidx.room:room-common:${BuildDependencyVersions.room_paginating_version}"

    // Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${BuildDependencyVersions.retrofit_version}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${BuildDependencyVersions.retrofit_version}"

    //OK Http
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${BuildDependencyVersions.okhttp_version}"

    const val RATING_BAR = "com.github.a914-gowtham:compose-ratingbar:${BuildDependencyVersions.rating_bar}"

    const val COIL = "io.coil-kt:coil-compose:${BuildDependencyVersions.coil}"

    const val SYSTEM_UI = "com.google.accompanist:accompanist-systemuicontroller:${BuildDependencyVersions.system_ui_version}"

    const val COMPOSE_UI_UTIL = "androidx.compose.ui:ui-util:${BuildDependencyVersions.compose_version}"

    const val RX_JAVA =  "io.reactivex.rxjava2:rxjava:${BuildDependencyVersions.rx_java}"

    const val RX_ANDROID = "io.reactivex.rxjava2:rxandroid:${BuildDependencyVersions.rx_android}"

    /*const val RX_JAVA =  "io.reactivex.rxjava3:rxjava:${BuildDependencyVersions.rx_java3}"

    const val RX_ANDROID = "io.reactivex.rxjava3:rxandroid:${BuildDependencyVersions.rx_android3}"*/

    const val RX_ADAPTER = "com.squareup.retrofit2:adapter-rxjava2:${BuildDependencyVersions.rx_adapter}"

    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${BuildDependencyVersions.constraint_layout}"

    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${BuildDependencyVersions.navigation_fragment}"

    const val NAVIGATION_KTX = "androidx.navigation:navigation-ui-ktx:${BuildDependencyVersions.navigation_fragment}"

    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${BuildDependencyVersions.activity_ktx}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${BuildDependencyVersions.activity_ktx}"

    const val PICASSO = "com.squareup.picasso:picasso:${BuildDependencyVersions.picasso}"

    const val MULTIDEX = "androidx.multidex:multidex:${BuildDependencyVersions.multidex}"

    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${BuildDependencyVersions.recyclerview}"

    const val GLIDE = "com.github.bumptech.glide:glide:${BuildDependencyVersions.glide}"

    const val LIFECYCLE_EXT = "androidx.lifecycle:lifecycle-extensions:${BuildDependencyVersions.lifecycle_ext}"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${BuildDependencyVersions.lifecycle_livedata}"
    const val LIFECYCLE_VIEWMODEL_SAVEDSTATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${BuildDependencyVersions.lifecycle_livedata}"
    const val LIFECYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${BuildDependencyVersions.lifecycle_livedata}"

    const val GSON = "com.google.code.gson:gson:${BuildDependencyVersions.gson}"

    const val OKHTTP_LOG = "com.squareup.okhttp3:logging-interceptor:${BuildDependencyVersions.okhttp_log}"
}