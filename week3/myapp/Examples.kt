package example.myapp

object Constants {
    const val CONSTANT2 = "object constant"
}
class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}
fun String.hasSpaces(): Boolean {
    val found = this.indexOf(' ')
    // also valid: this.indexOf(" ")
    // returns positive number index in String or -1 if not found
    return found != -1
}
// equals: fun String.hasSpaces() = indexOf(" ") != -1

open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")
val AquariumPlant.isGreen: Boolean
    get() = color == "green"
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}



fun main(){
    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())

    val equipment1 = "fish net" to "catching fish"
    val (tool, use) = equipment1
    println("$tool is used for $use")

    val numbers1 = Triple(6, 9, 42)
    val (n1, n2, n3) = numbers1
    println("$n1 $n2 $n3")

    val list = listOf(1, 5, 3, 4)
    println(list.sum())

    val list2 = listOf("a", "bbb", "cc")
    println(list2.sumBy { it.length })
    for (s in list2.listIterator()) {
        println("$s ")
    }

    val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras", "zebra fish" to "danio rerio" )
    println (scientific.get("guppy"))
    println(scientific.get("zebra fish"))
    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))
    println(scientific.getOrElse("swordtail") {"sorry, I don't know"})

    val foo = Constants.CONSTANT2
    println(foo)

    val plant = GreenLeafyPlant(size = 10)
    plant.print()
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()  // what will it print?
    println(aquariumPlant.isGreen)

    val plant1: AquariumPlant? = null
    plant1.pull()
}
