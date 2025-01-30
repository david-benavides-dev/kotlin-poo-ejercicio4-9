package classes

// * Identificador (podrá indicarlo o generarlo automáticamente), una descripción y un estado.
// * Un estado de tarea debe indicar si está pendiente o ya fue realizada (en este caso, deberá mostrar la fecha, con formato DD-MM-AAAA HH:MM:SS, en la que se marcó cómo realizada)
class Tarea(var identificador: Int, var descripcion: String, var estado: String) {

    fun crearTarea(descripcion: String): Tarea {
        return Tarea(identificador, descripcion, "estado")
    }

    override fun toString(): String {
        return "ID: ${identificador}, DESC: ${descripcion}, STATUS: ${estado}"
    }
}