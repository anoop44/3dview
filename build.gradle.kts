// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    var kotlinVersion:String by extra
    kotlinVersion = "1.3.61"

    var versionName: String by extra
    versionName = "1.0.0"

    var versionCode: Int by extra
    versionCode = 100

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("com.novoda:bintray-release:0.9.2")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}