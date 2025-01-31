package classes

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Clase que representa una lista de tareas.
 * Permite agregar, eliminar y cambiar el estado de las tareas.
 */
class ListaTareas {
    companion object {
        var IDENTIFICADOR_TAREA = 0
        const val TAREA_PENDIENTE = "Pendiente"
        const val TAREA_REALIZADA = "Realizada"
    }

    private val tareasAgregadas: MutableList<Tarea> = mutableListOf()

    /**
     * Agrega una nueva tarea a la lista con la descripción proporcionada.
     *
     * @param desc La descripción de la tarea a agregar.
     */
    fun agregarTarea(desc: String) {
        tareasAgregadas.add(Tarea(IDENTIFICADOR_TAREA, desc, TAREA_PENDIENTE))
        IDENTIFICADOR_TAREA ++
    }

    /**
     * Cambia el estado de una tarea a realizada o pendiente según su estado actual.
     *
     * @param id El identificador de la tarea cuyo estado se desea cambiar.
     * @return true si el estado se cambió exitosamente, false si la tarea no existe.
     */
    fun cambiarEstadoTarea(id: Int): Boolean {
        for (t in tareasAgregadas){
            if (t.identificador == id) {
                if(t.estado == TAREA_REALIZADA) {
                    t.estado = TAREA_PENDIENTE
                    t.fechaFinalizacion = null
                    return true
                } else {
                    t.estado = TAREA_REALIZADA
                    t.fechaFinalizacion = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
                    return true
                }
            }
        }
        println("La tarea no existe.")
        return false
    }

    /**
     * Muestra en la consola todas las tareas que están pendientes.
     */
    fun mostrarTareasPendientes() {
        for (t in tareasAgregadas) {
            if (t.estado == TAREA_PENDIENTE)
                println(t)
        }
    }

    /**
     * Muestra en la consola todas las tareas que han sido realizadas.
     */
    fun mostrarTareasRealizadas() {
        for (t in tareasAgregadas) {
            if (t.estado == TAREA_REALIZADA)
                println(t)
        }
    }

    /**
     * Elimina una tarea de la lista según su identificador.
     *
     * @param id El identificador de la tarea a eliminar.
     * @return true si la tarea fue eliminada exitosamente, false si la tarea no existe.
     */
    fun eliminarTarea(id: Int): Boolean {
        for (t in tareasAgregadas){
            if (t.identificador == id) {
                tareasAgregadas.remove(t)
                return true
            }
        }
        println("La tarea no existe.")
        return false
    }
}