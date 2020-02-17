package com.dam2.proyectofragments.dummy

import java.util.ArrayList
import java.util.HashMap

/**
* Clase de ayuda para proporcionar contenido de muestra para interfaces de usuario creadas por
* Asistentes de plantillas de Android.
*
 *
* TODO: Reemplace todos los usos de esta clase antes de publicar su aplicación.
*/

object DummyContent {

    /**
    * Una matriz de elementos de muestra (ficticios).
    */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
    *Un mapa de elementos de muestra (ficticios), por ID.
    */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 4





    init {
        //Agregue algunos elementos de muestra(de 1 a n).
            for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        //va añadiendo items
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

    private fun createDummyItem(position: Int): DummyItem {
        //crea items con los valores del array
        val p = arrayOf("Natillas", "Flan", "Arroz con leche", "Torrijas")
        return DummyItem(position.toString(), p.get(position-1) , makeDetails(position))

    }

    private fun makeDetails(position: Int): String {
        //Crea el contenido de los items
        val ingredientes = arrayOf("""Para 4 personas:
            .Leche 500 ml
            .Canela en rama 1
            .Vaina de vainilla 1
            .Piel de limón 1
            .Yema de huevo 4
            .Azúcar 75 g
            .Almidón de maíz  1 cucharada
            .Galletas tipo María""",
            """
                .80 g de Dulce de Leche 
                .196 ml de Leche evaporada
                .2 Huevos
                .1 cucharada de azúcar
                .1 cucharada de agua
                """,
            """
                .185 g de Leche
                .100 g de arroz
                .1 rama de canela
                .1 limón
                .canela en polvo
            """,
            """
                .Una barra de pan
                .Un litro de leche
                .Una rama de canela
                .100 gramos de azúcar
                .La cáscara de un limón 
                .La cáscara de una naranja
                .Tres huevos
                .Aceite de oliva
"""
        )

        val receta = arrayOf("""Colocar la leche en un cazo con la rama de canela, la vaina de vainilla que habremos abierto con un cuchillo y la corteza de limón - sólo la parte amarilla - . Calentar, llevar a ebullición y apartar del fuego. Dejar infusionar 15-20 minutos y colar.
Disponer las yemas de huevo con el azúcar en un cuenco y batir con unas varillas. Añadir la maizena, batir bien y echar poco a poco la leche, mezclando con las varillas para dejar una textura homogénea.
Poner a calentar un recipiente al baño maría y echar la preparación. Calentar, sin que el agua llegue a hervir, removiendo con las varillas constantemente, para que no se pegue. Continuar la cocción durante unos 10 minutos o algo más, hasta que espese. Recordar que en caliente la mezcla será siempre más líquida que cuando enfríe.
Llenar los recipientes que más nos gusten y dejar templar un poco. Colocar una galleta María con cuidado encima de cada ración y llevar a la nevera. Dejar enfriar completamente durante unas horas antes de servir.""",
            """Batir los huevos y añadir el Dulce de Leche y la leche evaporada.
Caramelizar un bol de cristal, no muy grande, con el azúcar y el agua, 2’ en el micro a 750W.
Verter la preparación anterior y cocerlo en el micro a la misma potencia, durante 4,30’.
Enfriar en el refrigerador y servirlo frio con salsa de chocolate o nata montada.
                """,
            """Preparación: Hervir el arroz durante 5 minutos en abundante agua; pasarlo por agua fría y escurrirlo.Poner en un cazo al fuego la leche condensada, 1/2 l de agua y una corteza de limón y la canela. Cuando empiece a hervir, añadir el arroz y cocerlo a fuego suave durante 20 minutos. Verterlo en tarrinas y dejarlo reposar. Espolvorear con canela en el momento de servirlo.
            """,
            """Corte con un cuchillo de sierra el pan, mejor en rodajas sesgadas de unos dos centímetros de grosor. Cueza la leche con la rama de canela y la cáscara de limón y naranja para aromatizar. Una vez atemperada (no fría) meta las rodajas de pan dentro. Deje que se empapen bien, como mínimo una hora. Una vez que estén jugosos, escurra bien los trozos de pan y páselos por el huevo batido. Fría las torrijas en una sartén con aceite abundante unos dos minutos cada una. Lo ideal es no meter demasiadas torrijas a la vez para que la textura sea la adecuada. Una vez fritas, póngalas en una fuente y espolvoreadas a su gusto: con azúcar y canela, con miel, con almíbar, con vino dulce, con mermelada..."""
            )

        val builder = StringBuilder()
        builder.append("Ingredientes: ")

            builder.append("\n\n"+ingredientes.get(position-1))
            builder.append("\n\n"+receta.get(position-1))

        return builder.toString()
    }

    /**
    *Un elemento ficticio que representa una pieza de contenido.
    */
    data class DummyItem(val id: String, val content: String, val details: String) {
        override fun toString(): String = content
    }
}
