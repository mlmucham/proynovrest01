package edu.isil.proynovrest1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // Inicializa la instancia de Retrofit con la URL base y el convertidor Gson.
    private val retrofit = Retrofit.Builder()
        // URL base para las solicitudes HTTP. Todas las solicitudes se construirán a partir de esta URL.
        .baseUrl("http://demo6855995.mockable.io/")
        // Añade el convertidor Gson para convertir las respuestas JSON en objetos Kotlin.
        .addConverterFactory(GsonConverterFactory.create())
        // Construye la instancia de Retrofit.
        .build()

    // Crea una implementación de la interfaz ConsumirApi para las solicitudes API.
    // Retrofit se encarga de crear la implementación de esta interfaz.
    val consumirApi: ConsumirApi = retrofit.create(ConsumirApi::class.java)
}
