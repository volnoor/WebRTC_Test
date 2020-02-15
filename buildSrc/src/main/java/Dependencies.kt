object Versions {

    val versionCode = 1
    val versionName = "1.0"
    val compileSdkVersion = 29
    val buildToolsVersion = "29.0.3"
    val minSdkVersion = 14
    val targetSdkVersion = 29


    val kotlin = "1.3.61"
    val appcompat = "1.1.0"
    val ktx = "1.2.0"
    val constraint_layout = "1.1.3"

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

    val junit = "junit:junit:${Versions.junit}"
    val android_junit = "androidx.test.ext:junit:${Versions.android_junit}"
    val espresso_core = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
}