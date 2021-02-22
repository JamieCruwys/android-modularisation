object Versions {
    // Build
    val min_sdk = 21
    val target_sdk = 30
    val compile_sdk = 30
    val build_tools = "29.0.3"
    val android_gradle_plugin = "4.1.2"

    // Kotlin
    val kotlin = "1.4.21"

    // Libraries
    val core_ktx = "1.3.2"
    val appcompat = "1.2.0"
    val recyclerview = "1.1.0"
    val material = "1.2.1"
    val constraint_layout = "2.0.4"
    val junit = "4.13.1"
    val androidx_junit = "1.1.2"
    val androidx_espresso = "3.3.0"
    val navigation = "2.3.3"
    val dagger_hilt = "2.31.2-alpha"
    val androidx_dagger_hilt = "1.0.0-alpha03"
    val timber = "4.7.1"
    val mockk = "1.10.2"
    val archTesting = "2.1.0"
    val kluent = "1.61"
    val espresso = "3.3.0"
    val coroutines = "1.4.0"
    val retrofit = "2.9.0"
    val gson = "2.8.6"
    val okhttp_logging_interceptor = "3.12.0"
    val detekt = "1.10.0"
    val spotless = "3.27.0"
}

object Libs {
    val kotlin_std_lib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val core_ktx = "androidx.core:core-ktx:${Versions.core_ktx}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    val material = "com.google.android.material:material:${Versions.material}"
    val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"
    val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val dagger_hilt = "com.google.dagger:hilt-android:${Versions.dagger_hilt}"
    val dagger_hilt_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.androidx_dagger_hilt}"
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_gson_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging_interceptor}"
}

object AnnotationLibs {
    val dagger_hilt_compiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger_hilt}"
    val androidx_dagger_hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.androidx_dagger_hilt}"
}

object UnitTestLibs {
    val junit = "junit:junit:${Versions.junit}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    val archTesting = "androidx.arch.core:core-testing:${Versions.archTesting}"
    val kluent = "org.amshove.kluent:kluent:${Versions.kluent}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

object UITestLibs {
    val androidx_junit = "androidx.test.ext:junit:${Versions.androidx_junit}"
    val androidx_espresso = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"
    val kluent = "org.amshove.kluent:kluent-android:${Versions.kluent}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val navigation = "androidx.navigation:navigation-testing:${Versions.navigation}"
}

object GradlePlugins {
    val android = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val dagger_hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger_hilt}"
    val detekt = "io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${Versions.detekt}"
    val spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Versions.spotless}"
}