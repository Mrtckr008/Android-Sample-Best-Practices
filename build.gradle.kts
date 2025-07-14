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
    alias(libs.plugins.kover) apply false
}

val koverPluginId    = libs.plugins.kover.get().pluginId
val androidPluginIds = listOf(
    "com.android.application",
    "com.android.library",
    "org.jetbrains.kotlin.jvm",
    "org.jetbrains.kotlin.android"
)

subprojects {
    androidPluginIds.forEach { target ->
        pluginManager.withPlugin(target) {
            apply(plugin = koverPluginId)
        }
    }
}