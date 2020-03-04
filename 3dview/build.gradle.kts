import com.novoda.gradle.release.PublishExtension

plugins {
    id("com.android.library")
    kotlin("android")
    id("com.novoda.bintray-release")
}


android {
    compileSdkVersion(29)

    defaultConfig {
        minSdkVersion(14)
        targetSdkVersion(29)
        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"] as String
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

configure<PublishExtension> {
    userOrg = "anoop44"
    groupId = "ss.anoop"
    artifactId = "3dview"
    publishVersion = rootProject.extra["versionName"] as String
    desc = "A simple ViewGroup that gives any view a 3d appearance"
    website = "https://github.com/anoop44/3dview"
}