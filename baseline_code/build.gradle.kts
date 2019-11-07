plugins {
    java
}

version = "unspecified"

repositories {
    mavenCentral()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation("org.jooq:jool-java-8:0.9.14")
    implementation("org.jooq:jool-java-8:0.9.14")
}

tasks.register("copyDeps", Copy::class) {
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
    into("build/target/deps")

}