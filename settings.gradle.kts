pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    resolutionStrategy {
        eachPlugin {
            if( requested.id.id == "dagger.hilt.android.plugin") {
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
            }
            if( requested.id.id == "androidx.navigation.safeargs") {
                useModule("androidx.navigation:navigation-safe-args-gradle-plugin::2.5.1")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
rootProject.name = "MyFamilyApp"
include (":app")
include(":core:feature-base-api")
include(":features:home:feature-home-api")
include(":features:home:feature-home-impl")
include(":core:dependency-provider")
include(":features:movie:feature_movie_api")
include(":features:tv:feature-tv-api")
include(":features:tv:presentation:feature-tv-impl")
include(":features:tv:data")
include(":features:tv:domain")
include(":features:artist:feature-artist-api")
include(":features:artist:presentation:feature-artist-impl")
include(":features:artist:artist-data")
include(":features:artist:artist-domain")
include(":core:network")
