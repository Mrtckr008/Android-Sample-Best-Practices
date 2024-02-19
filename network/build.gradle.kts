plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    id(libs.plugins.kotlin.kapt.get().pluginId)
    kotlin(libs.plugins.plugin.serializaton.get().pluginId)
}

android {
    namespace = "com.mrtckr.network"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    hilt {
        enableAggregatingTask = true
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.androidxAppcompat)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.hilt)
    implementation(libs.kotlinx.serialization.json)
    kapt(libs.bundles.hiltKapt)
    annotationProcessor(libs.hiltCompiler)
    testImplementation(libs.bundles.testing)
    androidTestImplementation(libs.bundles.testing)
}
