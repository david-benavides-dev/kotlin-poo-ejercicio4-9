package classes

import classes.ListaTareas.Companion.TAREA_PENDIENTE

/**
 * Clase que representa una tarea con un identificador, descripción y estado.
 *
 * @property identificador El identificador único de la tarea.
 * @property descripcion La descripción de la tarea.
 * @property estado El estado actual de la tarea (pendiente o realizada).
 */
class Tarea(var identificador: Int, private var descripcion: String, var estado: String) {

    var fechaFinalizacion: String? = null

    /**
     * Devuelve una representación en forma de cadena de la tarea.
     *
     * @return Una cadena que contiene el identificador, la descripción, el estado y, si corresponde, la fecha de finalización.
     */
    override fun toString(): String {
        return "ID: ${identificador}, DESC: $descripcion, STATUS: $estado ${if (estado == TAREA_PENDIENTE) "" else ", DATE_FINISHED: $fechaFinalizacion"}"
    }
}