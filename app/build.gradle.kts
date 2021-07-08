plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

apply(plugin = "androidx.navigation.safeargs.kotlin")
apply(plugin = "dagger.hilt.android.plugin")
apply(plugin = "com.jaredsburrows.license")

android {
    compileSdkVersion(30)
    buildToolsVersion("29.0.3")

    defaultConfig {
        applicationId = "dev.leonlatsch.photok"
        minSdkVersion(24)
        targetSdkVersion(30)
        versionCode = 15
        versionName = "1.3.1"
        buildConfigField(
            "int",
            "FEATURE_VERSION_CODE",
            "1"
        ) // Increase for new major or minor version. NEVER decrease!

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += "room.incremental" to "true"
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val roomVersion = "2.3.0-alpha04"
    val coroutinesVersion = "1.3.7"
    val pagingVersion = "3.0.0-alpha11"
    val daggerVersion = "2.31"
    val hiltVersion = "2.31-alpha"

    // Architectural Components
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    // Room
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")

    // Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$roomVersion")

    // ViewPager2
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion")

    // Coroutine Lifecycle Scopes
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    // Navigation Components
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    // Paging 3
    implementation("androidx.paging:paging-runtime-ktx:$pagingVersion")

    // Timber Logging
    implementation("com.jakewharton.timber:timber:4.7.1")

    // Dagger Core
    implementation("com.google.dagger:dagger:$daggerVersion")
    kapt("com.google.dagger:dagger-compiler:$daggerVersion")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")

    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt("androidx.hilt:hilt-compiler:1.0.0")

    // Activity KTX for viewModels()
    implementation("androidx.activity:activity-ktx:1.2.3")

    // Easy Permissions
    implementation("pub.devrel:easypermissions:3.0.0")

    // jBCrypt for Password Hashing
    implementation("org.mindrot", "jbcrypt", "0.4")

    // MikeOritz/TouchImageView - Zoomable Image View
    implementation("com.github.MikeOrtiz:TouchImageView:3.0.1")

    // Gson
    implementation("com.google.code.gson", "gson", "2.8.6")

    // Androidx ExifInterface
    implementation("androidx.exifinterface", "exifinterface", "1.3.0-alpha01")

    // Display OSS Licenses
    implementation("com.github.leonlatsch:OssLicenseView:1.1.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.11.0")

    // Exoplayer
    implementation("com.google.android.exoplayer:exoplayer-core:2.14.1")
    implementation("com.google.android.exoplayer:exoplayer-ui:2.14.1")

    implementation(fileTree("libs").matching {
        include("*.jar")
    })
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.preference:preference-ktx:1.1.1")

    testImplementation("junit:junit:4.13.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}
