package edu.iest.parcialdos.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iest.parcialdos.R
import edu.iest.parcialdos.models.MenuItem

// le pasamos un ArrayList porque es el tipo de datos que usamos en nuestro FakerMenu
class MenuAdapter(menuItems: ArrayList<MenuItem>, contexto : Context) :
    RecyclerView.Adapter<MenuAdapter.ContenedorDeVista> () {
    var innerMenuItems: ArrayList<MenuItem> = menuItems
    var innerContext: Context = contexto

    inner class ContenedorDeVista(view: View):
        RecyclerView.ViewHolder(view), View.OnClickListener {
            // identificamos con que elementos trabajaremos
            val ivMenu : ImageView
            val tvMenu : TextView

            init {
                ivMenu = view.findViewById(R.id.ivMenu)
                tvMenu = view.findViewById(R.id.tvMenu)
            }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContenedorDeVista {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_menu, parent, false)

        return ContenedorDeVista(view)    }

    override fun getItemCount(): Int {
        return innerMenuItems.size
    }

    override fun onBindViewHolder(holder: ContenedorDeVista, position: Int) {
        val menuItem: MenuItem = innerMenuItems.get(position)

        holder.ivMenu.setImageResource(menuItem.imagen)
        holder.tvMenu.text = menuItem.titulo
    }


}