package edu.iest.parcialdos.models

import edu.iest.parcialdos.R

// aqui agregamos todos los datos a usar en nuestro recycler
// este archivo contiene nuestro metodo para obtener todos los elementos que queremos agregar a nuestro recycleer
class FakerMenu {

    fun getMenuItems () : ArrayList<MenuItem> {
        var menuItems : ArrayList<MenuItem>
        menuItems = arrayListOf<MenuItem>()

        menuItems.add(MenuItem(1, R.drawable.cat,"Gatos"))
        menuItems.add(MenuItem(2, R.drawable.profile,"´Perfil"))
        menuItems.add(MenuItem(3, R.drawable.config,"Configurar"))
        menuItems.add(MenuItem(4, R.drawable.close,"Cerrar"))

        return menuItems
    }
}