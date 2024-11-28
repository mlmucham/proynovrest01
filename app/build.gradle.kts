plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "edu.isil.proynovrest1"
    compileSdk = 35

    defaultConfig {
        applicationId = "edu.isil.proynovrest1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    // Habilitar ViewBinding para generar automáticamente una clase de enlace para cada archivo de layout XML.
    // Esto facilita la interacción con las vistas del layout de manera segura y sin necesidad de usar findViewById().
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Retrofit es una biblioteca para realizar solicitudes HTTP de manera sencilla y robusta.
    // Esta línea añade la biblioteca principal de Retrofit, que se encarga de gestionar las
    // solicitudes HTTP, incluyendo GET, POST, PUT, DELETE, entre otras.
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    // Gson es una biblioteca de Google para la serialización y deserialización de objetos Java a JSON.
    // Esta línea añade el convertidor Gson para Retrofit, que permite convertir automáticamente
    // las respuestas JSON en objetos Java y viceversa.
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Implementación de RecyclerView para mostrar listas de datos de manera eficiente
    // en un formato de lista o cuadrícula. RecyclerView es más flexible y extensible que ListView.
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    // Implementación de ViewBinding para facilitar la interacción con las vistas del layout
    // de manera segura y sin necesidad de usar findViewById(). ViewBinding genera automáticamente
    // una clase de enlace para cada archivo de layout XML.
    implementation("androidx.databinding:viewbinding:4.1.2")

}