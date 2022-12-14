object BuildModules {

    const val APP = ":app"

    object Features {
        const val MOVIE = ":features:movie:feature_movie_api"
       // const val MOVIE_IMPL = ":features:movie:feature_movies_impl"
        const val BASE_API = ":core:feature-base-api"
        const val DEPENDENCY_PROVIDER = ":core:dependency-provider"
        const val CORE_NETWORK = ":core:network"

        const val HOME_API = ":features:home:feature-home-api"
        const val HOME_API_IMPL = ":features:home:feature-home-impl"

        const val TV_API = ":features:tv:feature-tv-api"
        const val TV_PRESENTATION_LAYER = ":features:tv:presentation:feature-tv-impl"
        const val TV_DATA_LAYER = ":features:tv:data"
        const val TV_DOMAIN_LAYER = ":features:tv:domain"

        const val ARTIST_API = ":features:artist:feature-artist-api"
        const val ARTIST_PRESENTATION_LAYER = ":features:artist:presentation:feature-artist-impl"
        const val ARTIST_DATA_LAYER = ":features:artist:artist-data"
        const val ARTIST_DOMAIN_LAYER = ":features:artist:artist-domain"
    }
}