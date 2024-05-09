plugins {
    id("java")
    id("io.quarkus") version "3.8.3"
    id("com.github.node-gradle.node") version "7.0.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
    mavenLocal()
}


object Versions {
    val quarkus = "3.8.3"
    val graal = "23.1.2"
    val jandex = "0.13.0"

    object apache {
        val commons_compress = "1.20"
        val commons_text = "1.9"
        val commons_net = "3.10.0"
    }

    val wireMock = "2.33.2"
    val hamcrest = "2.2"
    val versionsPlugin = "0.39.0"
    val micrometer_datadog_registry = "3.2.4"
    val awaitility = "4.2.0"
    val jsonassert = "1.5.0"
    val testContainers = "1.19.7"
    val systemStubs = "1.1.0"
    val reflections = "0.9.12"
    val shadow = "7.1.2"
    val awsJavaSDK = "1.12.376"
    val platformLimitsConsumer = "REL.2023-08-16_1423"
    val metricsAgent = "REL.2023-10-19_1227"
    val assertj = "3.24.0"
    val kafkaClients = "3.6.1"
}


dependencies {
    implementation(enforcedPlatform("io.quarkus.platform:quarkus-bom:${Versions.quarkus}"))
    implementation("io.quarkus", "quarkus-resteasy-jackson")
    implementation("io.quarkus", "quarkus-config-yaml")
    implementation("io.quarkus", "quarkus-smallrye-health")
    implementation("io.quarkus", "quarkus-smallrye-openapi")
    implementation("io.quarkus", "quarkus-smallrye-opentracing", Versions.quarkus)
    implementation("io.quarkus", "quarkus-hibernate-orm")
    implementation("io.quarkus", "quarkus-jdbc-postgresql")
    implementation("io.quarkus", "quarkus-hibernate-validator")
    implementation("io.quarkus", "quarkus-scheduler")
    implementation("io.quarkus", "quarkus-smallrye-reactive-messaging-kafka")
    implementation("io.quarkus", "quarkus-smallrye-fault-tolerance")
    implementation("io.quarkus", "quarkus-rest-client-jackson")

    implementation("org.apache.kafka", "kafka-clients", Versions.kafkaClients)

    // metrics
    implementation("io.quarkus", "quarkus-micrometer")

    implementation("io.quarkus", "quarkus-micrometer-registry-prometheus")
    implementation("io.quarkiverse.micrometer.registry", "quarkus-micrometer-registry-datadog", Versions.micrometer_datadog_registry)

    implementation("org.apache.commons", "commons-compress", Versions.apache.commons_compress)
    implementation("org.apache.commons", "commons-text", Versions.apache.commons_text)
    implementation("commons-net", "commons-net", Versions.apache.commons_net)

    implementation("org.graalvm.polyglot", "polyglot", Versions.graal)
    implementation("org.graalvm.polyglot", "js-community", Versions.graal)
    implementation("org.graalvm.js", "js-scriptengine", Versions.graal)
    implementation("org.graalvm.sdk", "nativeimage", Versions.graal)


    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.quarkus:quarkus-junit5-mockito")
    testImplementation("org.assertj:assertj-core:${Versions.assertj}")
    testImplementation("io.smallrye.reactive:smallrye-reactive-messaging-in-memory")
    testImplementation("org.awaitility:awaitility:${Versions.awaitility}")
    testImplementation("io.rest-assured:rest-assured")
    testImplementation("org.hamcrest:hamcrest:${Versions.hamcrest}")
    testImplementation("com.github.tomakehurst:wiremock-jre8:${Versions.wireMock}")
    testImplementation(enforcedPlatform("org.testcontainers:testcontainers-bom:${Versions.testContainers}"))
    testImplementation("org.testcontainers", "testcontainers")
    testImplementation("org.testcontainers", "localstack")
    testImplementation("org.testcontainers", "postgresql")
    testImplementation("org.testcontainers", "kafka")
    testImplementation("com.amazonaws", "aws-java-sdk-core", Versions.awsJavaSDK)
    testImplementation("org.reflections", "reflections", Versions.reflections)
    testImplementation("io.quarkus", "quarkus-jacoco")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}