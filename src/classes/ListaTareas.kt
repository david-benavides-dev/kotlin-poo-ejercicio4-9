package classes

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ListaTareas {
    companion object {
        var IDENTIFICADOR_TAREA = 0
        const val TAREA_PENDIENTE = "Pendiente"
        const val TAREA_REALIZADA = "Realizada"
    }

    private val tareasAgregadas: MutableList<Tarea> = mutableListOf()

    /**
     *
     */
    fun agregarTarea(desc: String) {
        val fechaHoraActual: LocalDateTime = LocalDateTime.now()
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")
        val fechaFormateada: String = fechaHoraActual.format(formatter)
        tareasAgregadas.add(Tarea(IDENTIFICADOR_TAREA, desc, TAREA_PENDIENTE, fechaFormateada))
        IDENTIFICADOR_TAREA ++
    }

    /**
     *
     */
    fun cambiarEstadoTarea(id: Int): Boolean {
        for (t in tareasAgregadas){
            if (t.identificador == id) {
                if(t.estado == TAREA_REALIZADA) {
                    t.estado = TAREA_PENDIENTE
                    return true
                } else {
                    t.estado = TAREA_REALIZADA
                    return true
                }
            }
        }
        println("La tarea no existe.")
        return false
    }


    /**
     *
     */
    fun mostrarTareasPendientes() {
        for (t in tareasAgregadas) {
            if (t.estado == TAREA_PENDIENTE)
                println(t)
        }
    }

    /**
     *
     */
    fun mostrarTareasRealizadas() {
        for (t in tareasAgregadas) {
            if (t.estado == TAREA_REALIZADA)
                println(t)
        }
    }

    /**
     *
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