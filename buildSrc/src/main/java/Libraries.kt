object TestInstrumentedRunner {
    const val Runner = "androidx.test.runner.AndroidJUnitRunner"
}

object CustomPlugin {

    private const val gradleVersion = "4.2.1"
    private const val ktlintVersion = "10.0.0"
    private const val KotlinVersion = "1.6.21"

    const val GradleVersion = "com.android.tools.build:gradle:${gradleVersion}"
    const val GradleKTlint = "org.jlleitschuh.gradle:ktlint-gradle:${ktlintVersion}"
    const val KotlinPlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${KotlinVersion}"

}

object NetworkLibraries {

    val Retrofit = arrayListOf(
        "com.squareup.retrofit2:retrofit:${Versions.NetworkLibraries.RetrofitVersion}",
        "com.squareup.retrofit2:converter-gson:${Versions.NetworkLibraries.GsonConverter}",
        "com.google.code.gson:gson:${Versions.NetworkLibraries.Gson}",
        "com.squareup.okhttp3:okhttp:${Versions.NetworkLibraries.OkHttpVersion}",
        "com.squareup.okhttp3:logging-interceptor:${Versions.NetworkLibraries.OkHttpVersion}",
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
    )

}

object ImageLoader {
    val Picasso = arrayListOf(
        "com.squareup.picasso:picasso:${Versions.ImageLoader.PicassoVersion}",
        "jp.wasabeef:picasso-transformations:2.4.0"
    )
}

object Coroutine {
    val Libraries = arrayListOf(
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.CoroutineVersion}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.CoroutineVersion}",
    )
}

object MaterialDesignLibraries {

    val Libraries = arrayListOf(
        "androidx.appcompat:appcompat:${Versions.MaterialDesign.AppCompatVersion}",
        "androidx.constraintlayout:constraintlayout:${Versions.MaterialDesign.ConstrainLayoutVersion}",
        "androidx.recyclerview:recyclerview:${Versions.MaterialDesign.RecyclerViewVersion}",
        "androidx.cardview:cardview:${Versions.MaterialDesign.CardViewVersion}",
        "com.google.android.material:material:${Versions.MaterialDesign.MaterialDesignVersion}" ,
        "com.facebook.shimmer:shimmer:${Versions.MaterialDesign.ShimmerVersion}"
    )

}

object TestingLibraries {
    const val Junit = "junit:junit:${Versions.Testing.JunitVersion}"

    const val JunitExtensions =
        "androidx.test.ext:junit:${Versions.Testing.JunitExtensionVersion}"

    const val Core = "androidx.test:core:${Versions.Testing.TestCoreVersion}"

    const val ArcCore = "androidx.arch.core:core-testing:${Versions.Testing.TestArcCoreVersion}"

    val MockK = arrayListOf(
        "io.mockk:mockk:${Versions.Testing.MockKVersion}",
        "io.mockk:mockk-agent-jvm:${Versions.Testing.MockKVersion}"
    )

    const val CoroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.Testing.KotlinCoroutineTestVersion}"

    const val Robolectric = "org.robolectric:robolectric:${Versions.Testing.RobolectricVersion}"

    const val Runner = "androidx.test:runner:${Versions.Testing.RunnersVersion}"

    const val Turbine = "app.cash.turbine:turbine:${Versions.Testing.TurbineVersion}"

    const val Hamcrest = "org.hamcrest:hamcrest-all:${Versions.Testing.HamcrestVersion}"

    const val Truth = "com.google.truth:truth:1.1.3"
}

object UITestingLibraries {
    val Espresso = arrayListOf(
        "androidx.test.espresso:espresso-core:${Versions.UITesting.EspressoVersion}"
    )
    const val FragmentTest =
        "androidx.fragment:fragment-testing:${Versions.UITesting.FragmentVersion}"

    const val AndroidXRuleTest = "androidx.test:rules:${Versions.UITesting.AndroidXRuleVersion}"
}

object AndroidLibrary {
    const val Core = "androidx.core:core-ktx:${Versions.Kotlin.CoreKtxVersion}"
}

object KotlinLibrary {
    const val Library = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.KotlinVersion}"
}

object Jetpack {


    val LifeCycle = arrayListOf(
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Jetpack.LifeCycleVersion}",
        "androidx.lifecycle:lifecycle-extensions:${Versions.Jetpack.LifeCycleExtensionsVersion}",
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.Jetpack.LifeCycleVersion}",
        //for viewModelScope
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Jetpack.LifeCycleVersion}",
        //for lifecycleScope
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Jetpack.LifeCycleVersion}",
        "androidx.activity:activity-ktx:${Versions.Jetpack.ActivityKtxVersion}",
    )

}

object DI {
    val Hilt = "com.google.dagger:hilt-android:${Versions.DI.HiltVersion}"
    val HiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.DI.HiltVersion}"
}