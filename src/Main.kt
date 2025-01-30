import classes.ListaTareas
import classes.Tarea

fun main() {
    var tareas = ListaTareas()
    var tareDefault = Tarea(0,"","")

    do {
        mostrarMenu()
        var opcion = pedirOpcion()
        when (opcion) {
            1 -> tareas.agregarTarea(Tarea(0,"a","a"))
            2 -> tareas.eliminarTarea(1)
            3 -> println("TEST3")
            4 -> tareas.mostrarTareas()
            5 -> println("TEST5")
            6 -> println("TEST6")
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
    var opcion: Int = 0
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