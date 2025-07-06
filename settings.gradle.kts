pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LiveCoding2"
include(":app")
include(":data")
include(":domain")
include(":network")
include(":common")
include(":dynamicboxanimator")
include(":feature:weather")
include(":feature:musicplayer")
include(":testutils")
