import classes.*

fun main() {
    val tareas = ListaTareas()

    do {
        mostrarMenu()
        val opcion = pedirOpcion()
        when (opcion) {
            1 -> {
                print("Introduce la descripción de la tarea >> ")
                tareas.agregarTarea(readln())
            }
            2 -> tareas.eliminarTarea(readln().toInt())
            3 -> tareas.cambiarEstadoTarea(readln().toInt())
            4 -> tareas.mostrarTareasPendientes()
            5 -> tareas.mostrarTareasRealizadas()
            6 -> println("Saliendo del programa...")
        }
    } while (opcion != 6)
}

/**
 * Muestra un menu por consola.
 */
fun mostrarMenu() {
    println("""GESTION DE TAREAS
        |1. Agregar una tarea nueva
        |2. Eliminar una tarea
        |3. Cambiar estado de tarea
        |4. Mostrar lista de tareas pendientes.
        |5. Mostrar lista de tareas realizadas.
        |6. Salir
    """.trimMargin())
}

/**
 * Pide que el usuario introduzca una opción por consola.
 * Se mantendrá en bucle si el usuario no introduce una opción
 * correcta.
 * @return La opción que el usuario ha introducido.
 */
fun pedirOpcion(): Int {
    var opcion = 0
    do {
        try {
            print("Introduce opción >> ")
            opcion = readln().toInt()
            if (opcion !in 1..6 ) {
                println("Opción incorrecta...")
                readln() // * Pausa del programa.
                opcion = 0
            }
        } catch (e: NumberFormatException) {
            println("ERROR >> Debes introducir un número...")
            readln()
        }
    } while (opcion == 0)
    return opcion
}