plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
//    id("org.jetbrains.compose")
//    id("com.squareup.sqldelight")

    }


kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java).all {
        binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
            export("dev.icerock.moko:mvvm-core:0.16.1")
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
      val commonMain by getting {
          //put your multiplatform dependencies here
          dependencies {
         // implementation(libs.compose.foundation)
        //  implementation(libs.compose.material3)


//          implementation("com.squareup.sqldelight:runtime:1.5.5")
//          implementation("com.squareup.sqldelight:coroutines-extensions:1.5.5")
//              implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
          }

        }
       val commonTest by getting{
           dependencies {
              // implementation(kotlin("test"))
           }
            //implementation(libs.kotlin.test)
        }
        val androidMain by getting {
            dependencies {
//                implementation("com.squareup.sqldelight:android-driver:1.5.5")
//                implementation("androidx.appcompat:appcompat:1.6.1")
//                implementation("androidx.activity:activity-compose:1.7.2")
            }
        }
        val androidUnitTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependencies {
                //implementation("com.squareup.sqldelight:native-driver:1.5.5")
            }
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }

    }
}

android {
    namespace = "com.madoka.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
//sqldelight {
//    database("ContactDatabase") {
//        packageName = "com.plcoding.contactscomposemultiplatform.database"
//        sourceFolders = listOf("sqldelight")
//    }
//}

dependencies {
//    implementation("androidx.core:core:1.10.1")
//    commonMainApi("dev.icerock.moko:mvvm-core:0.16.1")
//    commonMainApi("dev.icerock.moko:mvvm-compose:0.16.1")
//    commonMainApi("dev.icerock.moko:mvvm-flow:0.16.1")
//    commonMainApi("dev.icerock.moko:mvvm-flow-compose:0.16.1")
}