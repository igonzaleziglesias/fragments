package com.dam2.proyectofragments

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_item_detail.*

/**
*Una actividad que representa una sola pantalla de detalles del artículo. Esta
*la actividad solo se usa en dispositivos de ancho estrecho. En dispositivos del tamaño de una tableta,
*los detalles del artículo se presentan junto con una lista de artículos
*en una [ItemListActivity].
*/


class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // Muestra el botón Arriba en la barra de acción.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState no es nulo cuando hay un estado de fragmento
        // guardado de configuraciones anteriores de esta actividad
        // (por ejemplo, al girar la pantalla de vertical a horizontal).
        // En este caso, el fragmento se volverá a agregar automáticamente
        // a su contenedor, por lo que no necesitamos agregarlo manualmente.
        // Para obtener más información, consulte la guía API Fragmentos en:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Crea el fragmento de detalle y agrégalo a la actividad
            // usando una transacción de fragmento.
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        ItemDetailFragment.ARG_ITEM_ID,
                        intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                // Esta ID representa el botón Inicio o Arriba. En el caso de esto
                // actividad, se muestra el botón Arriba. por
                // más detalles, vea el patrón de navegación en Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                navigateUpTo(Intent(this, ItemListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
