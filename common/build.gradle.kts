plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
    namespace = "com.mrtckr.common"
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