plugins {
    application
}

application {
    mainClassName = "com.coditory.gradle.frontend.sample.Application"
}

dependencies {
    implementation(project(":frontend"))
    implementation("org.springframework.boot:spring-boot-starter-webflux:2.2.6.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-freemarker:2.2.6.RELEASE")
}