package edu.iest.parcialdos
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iest.parcialdos.adapters.MenuAdapter
import edu.iest.parcialdos.models.FakerMenu

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // si queremos cambiar el tono de nuestra barra de menu
       /* var actionBar: ActionBar?
        actionBar = supportActionBar
        var colorDrawable: ColorDrawable
        colorDrawable = ColorDrawable(Color.parseColor("#FF018786"))
        actionBar!!.setBackgroundDrawable(colorDrawable)*/

        // obtenemos los valores a mostrar con nuestra clase y metodo de FakerMenu
        val menuItems = FakerMenu().getMenuItems()
        val recycler = findViewById<RecyclerView>(R.id.recyclerMenu)

        // usamos gridLayoutManager para poner hacer dos columnas
        val gridLayoutManager = GridLayoutManager(this, 2)
        recycler.layoutManager = gridLayoutManager

        // al adaptador pasamos nuestro MenuAdapter con los datos obtenidos
        recycler.adapter = MenuAdapter(menuItems, this)
    }

    // para poner en nuestra barra el icono que queramos
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}