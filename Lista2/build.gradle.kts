// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript { // przed blokiem plugins
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.4")
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
}