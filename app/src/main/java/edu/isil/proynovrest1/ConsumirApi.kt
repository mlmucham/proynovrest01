package edu.isil.proynovrest1

import retrofit2.Call
import retrofit2.http.GET

// Interfaz de Retrofit para definir las solicitudes HTTP a la API.
// Esta interfaz contiene las definiciones de los endpoints y los métodos HTTP que se utilizarán.
interface ConsumirApi {
    // Método para obtener datos de la API desde el endpoint "persona".
    // La anotación @GET indica que este método realiza una solicitud HTTP GET.
    // El método devuelve un Call<Persona>, lo que representa una solicitud que puede ejecutarse
    // de manera asíncrona para obtener una respuesta de tipo Persona.
    @GET("persona")
    fun getTraer(): Call<Persona>
}