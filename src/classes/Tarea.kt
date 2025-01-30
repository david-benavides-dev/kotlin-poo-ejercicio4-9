package classes

class Tarea(var identificador: Int, var descripcion: String, var estado: String, var fechaCreacion: String) {


    override fun toString(): String {
        return "ID: ${identificador}, DESC: ${descripcion}, STATUS: ${estado}, DATE_ADDED: $fechaCreacion"
    }
}