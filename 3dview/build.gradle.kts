plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(29)

    defaultConfig {
        minSdkVersion(14)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    sourceSets["main"].java.srcDirs(
        "src/main/kotlin"
    )
}

dependencies {
    implementation(kotlin("stdlib-jdk7", rootProject.extra["kotlinVersion"] as String ))
}