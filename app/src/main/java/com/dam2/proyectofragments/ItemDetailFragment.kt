package com.dam2.proyectofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dam2.proyectofragments.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*

/**
*Un fragmento que representa una sola pantalla de detalles del artículo.
*Este fragmento está contenido en una [ItemListActivity]
*en modo de dos paneles (en tabletas) o un [ItemDetailActivity]
*en teléfonos.
*/

class ItemDetailFragment : Fragment() {
    /**
    *El contenido ficticio que presenta este fragmento.
    */
    private var item: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                //Carga el contenido ficticio especificado por el fragmento
                // argumentos. En un escenario del mundo real, use un cargador
                // para cargar contenido de un proveedor de contenido.
                item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.toolbar_layout?.title = item?.content
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Muestra el contenido ficticio como texto en TextView.
        item?.let {
            rootView.item_detail.text = it.details
        }

        return rootView
    }

    companion object {
        /**
        *El argumento de fragmento que representa la ID del elemento que este fragmento
        *representa.
        */
        const val ARG_ITEM_ID = "item_id"
    }
}
