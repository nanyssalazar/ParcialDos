package edu.iest.parcialdos
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.option_menu_list_images) {
            //Toast.makeText(this,"Conectado a Internet",Toast.LENGTH_LONG).show()
            if(isOnline(this)) {
                Toast.makeText(this, "Conectado a Internet", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Sin conexión a Internet", Toast.LENGTH_LONG).show()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.d("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    Log.d("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.d("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }
}