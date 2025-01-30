package classes

class ListaTareas {
    companion object {
        var IDENTIFICADOR_TAREA = 0
    }

    private val subtareas: MutableList<Tarea> = mutableListOf()
    // TODO
    // Métodos:
    // Cambiar el estado de una tarea.
    // Mostrar lista de tareas (todas las tareas).
    // Mostrar lista de tareas pendientes.
    // Mostrar lista de tareas ya realizadas.

    fun agregarTarea(t: Tarea) {
        println("Introduce la descripción de la tarea >> ")
        t.descripcion = readln()
        t.identificador = IDENTIFICADOR_TAREA
        IDENTIFICADOR_TAREA ++
        t.estado = "Pendiente"
        subtareas.add(t)
    }

    fun mostrarTareas() {
        for (tarea in subtareas) {
            println(tarea)
        }
    }

    fun eliminarTarea(id: Int): Boolean {
        for (t in subtareas){
            if (t.identificador == id) {
                subtareas.remove(t)
                return true
            }
        }
        return false
    }
}