plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.jetbrains.plugin.serializaton)
    alias(libs.plugins.paparazzi) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.compose.screenshot)
    alias(libs.plugins.toolchains) apply false
    id("org.jetbrains.kotlinx.kover") apply false
}

subprojects {
    plugins.withId("com.android.application")    { apply(plugin = "org.jetbrains.kotlinx.kover") }
    plugins.withId("com.android.library")        { apply(plugin = "org.jetbrains.kotlinx.kover") }
    plugins.withId("org.jetbrains.kotlin.jvm")   { apply(plugin = "org.jetbrains.kotlinx.kover") }
    plugins.withId("org.jetbrains.kotlin.android"){ apply(plugin = "org.jetbrains.kotlinx.kover") }
}