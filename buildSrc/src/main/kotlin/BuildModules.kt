object BuildModules {

    const val APP = ":app"

    object Features {
        const val MOVIE = ":moviemodule"
        const val BASE_API = ":core:feature-base-api"
        const val DEPENDENCY_PROVIDER = ":core:dependency-provider"
        const val HOME_API = ":features:feature-home-api"
        const val HOME_API_IMPL = ":features:feature-home-impl"
    }
}