plugins {
    java
}

version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    // This dependency is used by the application.
    implementation("com.google.guava:guava:28.0-jre")
    implementation("org.xeustechnologies:jcl-core:2.8")
    implementation("commons-beanutils:commons-beanutils:1.9.3")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.assertj:assertj-core:3.11.1")
    implementation("com.thoughtworks.xstream:xstream:1.4.11.1")
    implementation("org.jooq:joor-java-8:0.9.7")
    implementation("org.apache.commons:commons-configuration2:2.0")

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.2")
}

val test by tasks.getting(Test::class) {
    // Use junit platform for unit tests
    useJUnitPlatform()
}
