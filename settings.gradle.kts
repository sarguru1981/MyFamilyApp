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
include (":moviemodule")
include(":core:feature-base-api")
include(":features:feature-home-api")
include(":features:feature-home-impl")
include(":core:dependency-provider")
