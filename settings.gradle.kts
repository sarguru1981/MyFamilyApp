pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MyFamilyApp"
include (":app")
include(":core:feature-base-api")
include(":features:home:feature-home-api")
include(":features:home:feature-home-impl")
include(":core:dependency-provider")
include(":features:movie:feature_movie_api")
