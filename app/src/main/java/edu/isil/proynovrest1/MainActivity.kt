package edu.isil.proynovrest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import edu.isil.proynovrest1.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// MainActivity es la actividad principal de la aplicación donde se configura la UI
// y se maneja la lógica para obtener y mostrar datos de una API utilizando Retrofit.
class MainActivity : AppCompatActivity() {

    // ViewBinding para acceder a las vistas definidas en el layout activity_main.xml de manera segura.
    lateinit var binding: ActivityMainBinding

    // Método onCreate se llama cuando la actividad es creada. Aquí se inicializa la UI.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflar el layout utilizando ViewBinding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Establecer el contenido de la actividad con la raíz de la vista vinculada.
        setContentView(binding.root)

        // Configurar el RecyclerView con un LinearLayoutManager para manejar la lista de familiares.
        binding.rvFamiliares.layoutManager = LinearLayoutManager(this)

        // Configurar el botón para llamar al método fetchData() cuando se haga clic.
        binding.btnFetchData.setOnClickListener {
            fetchData()
        }
    }

    // Método fetchData para realizar una solicitud a la API y obtener datos.
    private fun fetchData() {
        // Obtener una instancia del servicio API a través de RetrofitClient.
        val retrofitTraer = RetrofitClient.consumirApi.getTraer()

        // Ejecutar la solicitud de manera asíncrona.
        retrofitTraer.enqueue(object : Callback<Persona> {
            // Método onResponse se llama cuando se recibe una respuesta de la API.
            override fun onResponse(call: Call<Persona>, response: Response<Persona>) {
                if (response.isSuccessful && response.body() != null) {
                    // Obtener el objeto Persona de la respuesta.
                    val persona = response.body()!!
                    // Actualizar las vistas con los datos de la persona.
                    binding.tvNombrePersona.text = persona.nombre
                    binding.tvDireccionPersona.text = persona.direccion

                    // Configurar el RecyclerView con un adaptador para mostrar la lista de familiares.
                    val adapter = FamiliarAdapter(persona.familiares)
                    binding.rvFamiliares.adapter = adapter
                } else {
                    // Log para verificar el código de respuesta y cuerpo de error.
                    Log.e("API_RESPONSE_ERROR", "Código de respuesta: ${response.code()}, Error: ${response.errorBody()?.string()}")
                    // Mostrar un mensaje de error si la respuesta no es exitosa.
                    Toast.makeText(this@MainActivity, "Error en la respuesta del servidor", Toast.LENGTH_SHORT).show()
                }
            }

            // Método onFailure se llama cuando la solicitud falla.
            override fun onFailure(call: Call<Persona>, t: Throwable) {
                // Log para registrar el mensaje de error y la excepción.
                Log.e("API_FAILURE", "Error al consultar API Rest: ${t.message}", t)
                // ostream un mensaje de error si la solicitud falla.
                Toast.makeText(this@MainActivity, "Error al consultar Api Rest", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
