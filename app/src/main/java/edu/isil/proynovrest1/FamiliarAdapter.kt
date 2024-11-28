package edu.isil.proynovrest1


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adaptador para el RecyclerView que maneja una lista de objetos Familiare.
// Este adaptador es responsable de crear y enlazar las vistas para cada elemento de la lista.
class FamiliarAdapter(private val familiares: List<Familiare>) :
    RecyclerView.Adapter<FamiliarAdapter.FamiliarViewHolder>() {

    // ViewHolder para FamiliarAdapter. Mantiene las referencias a las vistas de cada elemento.
    class FamiliarViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(R.id.tvNombre)
        val tvRelacion: TextView = view.findViewById(R.id.tvRelacion)
        val tvDireccion: TextView = view.findViewById(R.id.tvDireccion)
    }

    // Crea una nueva vista para cada elemento de la lista.
    // Este método se llama cuando el RecyclerView necesita crear un nuevo ViewHolder.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamiliarViewHolder {
        // Inflar el diseño del elemento de la lista desde el archivo XML item_familiar.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_familiar, parent, false)
        // Crear y devolver un nuevo ViewHolder con la vista inflada.
        return FamiliarViewHolder(view)
    }

    // Enlaza los datos a las vistas del ViewHolder.
    // Este método se llama cuando el RecyclerView necesita mostrar un elemento específico.
    override fun onBindViewHolder(holder: FamiliarViewHolder, position: Int) {
        // Obtener el objeto Familiare para la posición actual.
        val familiar = familiares[position]
        // Asignar los datos del objeto Familiare a las vistas correspondientes.
        holder.tvNombre.text = familiar.nombre
        holder.tvRelacion.text = familiar.relacion
        holder.tvDireccion.text = familiar.direccion
    }

    // Devuelve el número total de elementos en la lista.
    override fun getItemCount() = familiares.size
}