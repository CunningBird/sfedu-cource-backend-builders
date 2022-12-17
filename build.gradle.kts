import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Плагины для сборки проекта
plugins {
    id("org.springframework.boot") version "3.0.0" // Плагин для сборки Spring Boot приложения в .jar
    id("io.spring.dependency-management") version "1.1.0" // Плагин для управления версиями библиотек (чтобы они были совместимы между собой)
    kotlin("jvm") version "1.7.21" // Плагин для трансляции исходного кода в byteCode (конкретно - трансляции языка Kotlin)
    kotlin("plugin.spring") version "1.7.21" // Плагин для работы с Spring-библиотеками на языке Kotlin
}

//Параметры ахрива
group = "com.example" // Package проекта
version = "0.0.1-SNAPSHOT" // Версия проекта
java.sourceCompatibility = JavaVersion.VERSION_17 // Версия исходного кода

// Откуда качать библиотеки
repositories {
    mavenCentral() // с Maven Repository
}

// Библиотеки для работы приложения
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web") // Работа по сети (Приём запросов, работа с портами и т.д.)
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // Сериализация/Десериализация на языке котлин
    implementation("org.jetbrains.kotlin:kotlin-reflect") // Рефлексия для языка Kotlin (нужна спригу)
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8") // Базовая библиотека на языке Kotlin
    testImplementation("org.springframework.boot:spring-boot-starter-test") // Для тестирования приложения
}

// Настройка копиляции Kotlin
tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17" // Транслирвоать в Java 17
    }
}

// Настройка запуска тестов
tasks.withType<Test> {
    useJUnitPlatform() // Использовать JUNIT из spring-boot-starter-test
}
