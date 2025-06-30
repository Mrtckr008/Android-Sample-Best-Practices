plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
    namespace = "com.mrtckr.common"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    hilt {
        enableAggregatingTask = true
    }
}

dependencies {
    implementation(libs.androidxAppcompat)
    implementation(libs.javaxInject)
    implementation(libs.bundles.hilt)
    kapt(libs.bundles.hiltKapt)
    annotationProcessor(libs.hiltCompiler)
    testImplementation(libs.bundles.testing)
    androidTestImplementation(libs.bundles.testing)
}