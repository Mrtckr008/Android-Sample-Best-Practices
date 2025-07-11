plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.paparazzi)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.compose.screenshot)
    id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
    namespace = "com.mrtckr.livecoding2"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.mrtckr.livecoding2"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    hilt {
        enableAggregatingTask = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    allprojects {
        java {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(21))
            }
        }

        tasks.withType<Test>().configureEach {
            javaLauncher.set(
                javaToolchains.launcherFor {
                    languageVersion.set(JavaLanguageVersion.of(21))
                }
            )
        }
    }

    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
    implementation(libs.bundles.androidxCore)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.composeAdditional)
    implementation(libs.bundles.navigation)
    implementation(libs.bundles.hilt)
    implementation(libs.bundles.otherLibraries)
    implementation(libs.bundles.retrofit)
    implementation(libs.androidx.media3.session)
    kapt(libs.bundles.hiltKapt)
    annotationProcessor(libs.hiltCompiler)
    debugImplementation(libs.composeUiTooling)
    debugImplementation(libs.androidx.compose.ui.testManifest)
    testImplementation(libs.bundles.testing)
    androidTestImplementation(libs.bundles.uiTesting)

    screenshotTestImplementation(libs.composeUiTooling)
    screenshotTestImplementation(libs.screenshot.validation.api)

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":common"))
    implementation(project(":dynamicboxanimator"))
    implementation(project(":feature:weather"))
    implementation(project(":feature:musicplayer"))
    testImplementation(project(":testutils"))
}

apply(from = "guava-fix.gradle")
