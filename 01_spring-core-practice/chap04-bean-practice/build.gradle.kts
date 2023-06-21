plugins {
    id("java")
}

group = "com.ohgiraffers"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("org.springframework:spring-core:5.3.27")
    implementation("org.springframework:spring-context:5.3.27")
    implementation("org.springframework:spring-beans:5.3.27")
    implementation("org.springframework:spring-expression:5.3.27")
    implementation("org.springframework:spring-aop:5.3.27")
    implementation("commons-logging:commons-logging:1.2")

    implementation("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")

    implementation("javax.annotation:javax.annotation-api:1.3.2")

    implementation("javax.inject:javax.inject:1")
}

tasks.test {
    useJUnitPlatform()
}