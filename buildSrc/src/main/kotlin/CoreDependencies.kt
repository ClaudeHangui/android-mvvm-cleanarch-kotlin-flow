object Versions {

    // Project configurations
    const val kotlinVersion = "1.3.72"
    const val minSdk = 16
    const val targetSdk = 30
    const val compileSdk = 30
    const val buildTools = "30.0.2"
    const val applicationId = "com.changui.android_mvvm_cleanarch_kotlin_flow"
    const val applicationVersionCode = 1
    const val applicationVersionName = "1.0"
    const val multiDexApp = "2.0.1"
    // Android core libraries
    const val appCompat = "1.2.0"
    const val materialComponents = "1.3.0"
    const val constraintLayout = "2.0.4"
    const val coreKotlinExtensions = "1.3.2"
    const val navHostFragment = "2.3.5"

    // App dependencies
    const val lifeCycle = "2.2.0"
    const val kotlinExtLiveData = "2.3.0"
    const val room = "2.2.6"
    const val paging = "2.1.2"
    const val workManager = "2.4.0"
    const val moshi = "1.11.0"
    const val retrofit = "2.9.0"
    const val okhttp = "4.9.0"
    const val coil = "1.1.1"
    const val koin = "2.2.2"
    const val coroutines = "1.4.2"
    const val coroutinesAdapter = "0.9.2"
    const val arrow = "0.13.1"
    // Code formatter
    const val ktlint = "9.4.1"
    // Gradle version update
    const val gradleVersionPlugin = "0.37.0"
    // code coverage
    const val jacoco = "0.8.5"
    // static code analysis
    const val detekt = "1.15.0"

    // testing
    const val unitTestJunit = "4.13.1"
    const val testCoreKtx = "1.2.0"
    const val androidXTest = "1.2.0"
    const val androidArchCoreTest = "2.1.0"
    const val integrationTestJunit = "1.1.1"
    const val integrationTestTruthAssertion = "1.2.0"
    const val espressoCore = "3.3.0"
    const val espressoContrib = "3.3.0"
    const val espressoIntent = "3.3.0"
    const val espressoIdlingResource = "3.2.0"
}

object Libraries {
    // App Dependencies
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val coreKotlinExtensions = "androidx.core:core-ktx:${Versions.coreKotlinExtensions}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val materialComponents = "com.google.android.material:material:${Versions.materialComponents}"
    const val multiDexApplication = "androidx.multidex:multidex:${Versions.multiDexApp}"
    const val navHostFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navHostFragment}"
    const val navHostUi = "androidx.navigation:navigation-ui:${Versions.navHostFragment}"
    const val lifecyleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifeCycle}"
    const val lifecyleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.kotlinExtLiveData}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycle}"
    const val reactiveStreams = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifeCycle}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKotlinExtension = "androidx.room:room-ktx:${Versions.room}"
    const val kotlinExtRoom = "androidx.room:room-ktx:${Versions.room}"
    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.paging}"
    const val workManagerRuntime = "androidx.work:work-runtime-ktx:${Versions.workManager}"
    const val koinCore = "org.koin:koin-core:${Versions.koin}"
    const val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.coroutinesAdapter}"
    const val moshiKotlinSupport = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiCodeGenerator = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    const val moshiConverterFactory = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val arrow = "io.arrow-kt:arrow-fx-coroutines:${Versions.arrow}"
    // Test Libraries
    const val unitTestJunit = "junit:junit:${Versions.unitTestJunit}"
    const val integrationTestJunit = "androidx.test.ext:junit:${Versions.integrationTestJunit}"
    const val integrationTestTruthAssertion = "androidx.test.ext:truth:${Versions.integrationTestTruthAssertion}"
    const val coreKotlinExtTest = "androidx.test:core-ktx:${Versions.testCoreKtx}"
    const val androidXTest = "androidx.test:core:${Versions.androidXTest}"
    const val androidArchCoreTest = "androidx.arch.core:core-testing:${Versions.androidArchCoreTest}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoContrib}"
    const val espressoIdlingResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoIdlingResource}"
    const val espressoIntent = "androidx.test.espresso:espresso-intents:${Versions.espressoIntent}"
}

object BuildPlugins {
    const val klintGradlePlugin = "org.jlleitschuh.gradle.ktlint"
    const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    const val detektGradlePlugin = "io.gitlab.arturbosch.detekt"
    const val jacocoScriptPlugin = "scriptplugins.jacoco-report"
}