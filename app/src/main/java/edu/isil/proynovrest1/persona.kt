package edu.isil.proynovrest1

data class Persona(
    val direccion: String,
    val edad: Int,
    val id: Int,
    val nombre: String,
    val familiares: List<Familiare>
)
