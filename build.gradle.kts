plugins {
    kotlin("jvm") version "1.9.0"
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "cn.xor7.raystone"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        name = "LeavesMC-Repository"
        url = uri("https://repo.leavesmc.top/snapshots")
    }
}

dependencies {
    compileOnly("top.leavesmc.leaves:leaves-api:1.20.2-R0.1-SNAPSHOT")
    implementation("cn.xor7.code.raystone:raystone-api:1.0.0-SNAPSHOT")
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("")
}