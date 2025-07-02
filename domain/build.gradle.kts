plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    implementation(libs.javaxInject)
    implementation(libs.junit)
    implementation(libs.kotlinxCoroutinesTest)
    testImplementation(libs.javaxInject)
    testImplementation(libs.mockitoKotlin)
}