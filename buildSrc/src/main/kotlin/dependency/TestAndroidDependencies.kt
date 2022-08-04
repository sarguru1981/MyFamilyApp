package dependency

object TestAndroidDependencies {

    const val ESPRESSO = "androidx.test.espresso:espresso-core:${BuildDependencyVersions.espresso_version}"
    const val EXT_JUNIT = "androidx.test.ext:junit:${BuildDependencyVersions.ext_junit_version}"
    const val COMPOSE_JUNIT = "androidx.compose.ui:ui-test-junit4:${BuildDependencyVersions.compose_version}"
    const val ANNOTATION =  "androidx.annotation:annotation:${BuildDependencyVersions.annotation}"

}