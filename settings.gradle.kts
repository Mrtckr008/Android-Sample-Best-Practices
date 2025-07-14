pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("org.jetbrains.kotlinx.kover") version "0.9.1"
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
