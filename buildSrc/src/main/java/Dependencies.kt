object Versions {

    val versionCode = 1
    val versionName = "1.0"
    val compileSdkVersion = 29
    val buildToolsVersion = "29.0.3"
    val minSdkVersion = 14
    val targetSdkVersion = 29

    val gradle_plugin = "3.5.3"
    val kotlin = "1.3.61"
    val appcompat = "1.1.0"
    val ktx = "1.2.0"
    val constraint_layout = "1.1.3"
    val support_v4 = "1.0.0"
    val lifecycle = "2.2.0"

    val junit = "4.13"
    val android_junit = "1.1.1"
    val espresso_core = "3.2.0"
}

object Dependencies {
    val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val androidx_ktx = "androidx.core:core-ktx:${Versions.ktx}"
    val androidx_constraint_layout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val androidx_support_v4 = "androidx.legacy:legacy-support-v4:${Versions.support_v4}"
    val androidx_lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val androidx_lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    val junit = "junit:junit:${Versions.junit}"
    val android_junit = "androidx.test.ext:junit:${Versions.android_junit}"
    val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"

    val databinding = "com.android.databinding:compiler:${Versions.gradle_plugin}"
    val gradle_plugin = "com.android.tools.build:gradle:${Versions.gradle_plugin}"
    val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}