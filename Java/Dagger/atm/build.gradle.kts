plugins {
    java
}

group = "ro.razvan.java.dagger.atm"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
}

dependencies {
    implementation(Libs.Dagger.dagger)
    annotationProcessor(Libs.Dagger.compiler)
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
}