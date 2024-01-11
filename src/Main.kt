/**
 * @param movimientos List<Int> Lista de movimientos que debe realizar el robot.
 * @return List<Int>
 */
fun mover( movimientos: List<Int>): List<Int> {
    var posx = 0
    var posy = 0
    var direccion = 0
    for (i in movimientos) {
        when (direccion) {
            0 -> posy += i
            1 -> posx -= i
            2 -> posy -= i
            3 -> posx += i
        }
        if (direccion == 3) direccion = 0 else direccion++
    }
    return listOf(posx, posy, direccion)
}

fun orientacionRobot(direccion: Any) = when (direccion) {
    0 -> "POSITIVEY"
    1 -> "NEGATIVEX"
    2 -> "NEGATIVEY"
    3 -> "POSITIVEX"
    else -> ""
}

fun pedirMov(): Int? {
    println("Introduce los movimientos: ")
    val num = readln().toIntOrNull()
    if (num != null) {
        return num
    } else {
        return null
    }
}

fun crearLista(): List<Int> {

    val lista = mutableListOf<Int>()
    while (true) {
        val numeros = pedirMov()
        if (numeros != null) {
            lista.add(numeros)
        } else {
            break
        }
    }
    return lista
}

fun main() {
    do {
        val lista = crearLista()
        val posicion: List<Int> = mover(lista)
        println("x: ${posicion[0]}, y: ${posicion[1]}, direction: ${orientacionRobot(posicion[2])}")
    }while (true)

}