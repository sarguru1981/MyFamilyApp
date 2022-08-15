package extensions

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import dependency.TestAndroidDependencies
import dependency.TestDependencies
import dependency.DebugDependencies
import dependency.Dependencies

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

/**
 * Adds a dependency to the `debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `testImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)


/**
 * Adds a dependency to the `androidTestImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

/**
 * Adds all the tests dependencies to specific configuration.
 */
fun DependencyHandler.addTestsDependencies() {
    testImplementation(TestDependencies.JUNIT)

    androidTestImplementation(TestAndroidDependencies.ESPRESSO)
    androidTestImplementation(TestAndroidDependencies.EXT_JUNIT)
    androidTestImplementation(TestAndroidDependencies.COMPOSE_JUNIT)
    androidTestImplementation(TestAndroidDependencies.ANNOTATION)
}

/**
 * Adds all the debug dependencies to specific configuration.
 */
fun DependencyHandler.addDebugDependencies() {
    debugImplementation(DebugDependencies.COMPOSE_UI)
    debugImplementation(DebugDependencies.COMPOSE_UI_TEST)
}

fun DependencyHandler.addAPIDependencies() {
    api(Dependencies.COMPOSE_UI)
    api(Dependencies.COMPOSE_NAVIGATION)
}

fun DependencyHandler.addDependenciesForCompose() {
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_MATERIAL)
}

fun DependencyHandler.addBaseDependencies() {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APP_COMPACT)
    implementation(Dependencies.MATERIAL)
}

fun DependencyHandler.addDaggerDependencies() {
    implementation (Dependencies.HILT_LIB)
    kapt (Dependencies.HILT_ANDROID_COMPILER)
    implementation (Dependencies.HILT_VIEWMODEL_LIFECYCLE)
    kapt (Dependencies.HILT_COMPILER)
    implementation (Dependencies.HILT_NAVIGATION)
}

fun DependencyHandler.addCoroutineAndLifecycleDependencies() {
    implementation (Dependencies.COROUTINE_CORE)
    implementation (Dependencies.COROUTINE_ANDROID)
    implementation (Dependencies.COROUTINE_PLAY_SERVICE)
    implementation (Dependencies.LIFECYCLE_VIEWMODEL)
    implementation (Dependencies.LIFECYCLE_RUNTIME)
}

fun DependencyHandler.addRetrofitDependencies() {
    implementation (Dependencies.RETROFIT)
    implementation (Dependencies.RETROFIT_GSON)
    implementation (Dependencies.OKHTTP)
}

fun DependencyHandler.addRoomDependencies() {
    implementation (Dependencies.ROOM_RUNTIME)
    kapt (Dependencies.ROOM_COMPILER)
    implementation (Dependencies.ROOM)
    implementation (Dependencies.ROOM_PAGING)
    implementation (Dependencies.ROOM_COMMON)
}

fun DependencyHandler.addRXDependencies() {
    implementation (Dependencies.RX_JAVA)
    implementation (Dependencies.RX_ANDROID)
    implementation (Dependencies.RX_ADAPTER)
}

