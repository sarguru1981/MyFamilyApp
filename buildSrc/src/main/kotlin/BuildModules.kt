object BuildModules {

    const val APP = ":app"

    object Features {
        const val MOVIE = ":features:movie:feature_movie_api"
       // const val MOVIE_IMPL = ":features:movie:feature_movies_impl"
        const val BASE_API = ":core:feature-base-api"
        const val DEPENDENCY_PROVIDER = ":core:dependency-provider"
        const val HOME_API = ":features:home:feature-home-api"
        const val HOME_API_IMPL = ":features:home:feature-home-impl"
    }
}