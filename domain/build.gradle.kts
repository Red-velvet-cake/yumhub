import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin-kapt")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    implementation ("com.google.dagger:dagger:2.44")
    kapt("com.google.dagger:dagger-compiler:2.44")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
}