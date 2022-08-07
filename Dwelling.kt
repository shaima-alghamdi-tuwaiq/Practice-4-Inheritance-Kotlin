import kotlin.math.PI


fun main() {

    // Create SqaureCabin
    val sqaureCabin = SqaureCabin(10, 50.0)
    
    with(sqaureCabin){
        	println("\nSquare Cabin\n============")
    		println("Material: ${buildingMaterial}")
    		println("Capacity: ${capacity}")  
            println("Floor Area: ${floorArea()}")
    		println("Has Room?? ${hasRoom()}")
            getRoom()
    }
    
    // Create RoundHut
    val roundHut = RoundHut(1, 10.0)
    
    with(roundHut){
        	println("\nRound Hut\n============")
    		println("Material: ${buildingMaterial}")
    		println("Capacity: ${capacity}")   
            println("Floor Area: ${floorArea()}")
    		println("Has Room?? ${hasRoom()}")
            getRoom()
    }
    
    // Create RoundTower
    val roundTower = RoundTower(50, 15.0, 10)
    
    with(roundTower){
        	println("\nRound Tower\n============")
    		println("Material: ${buildingMaterial}")
    		println("Capacity: ${capacity}")   
            println("Floor Area: ${floorArea()}")
    		println("Has Room?? ${hasRoom()}")
            getRoom()
    }
    
}

// Base Class - Parent Class - Super Class 
abstract class Dwelling(private var residents : Int){ // Buidling Class 
    
    // Attributes 
    abstract val buildingMaterial : String
    abstract val capacity : Int 
    
    
    // Fuctions - Methods 
    fun hasRoom() : Boolean {
        return residents <= capacity
    }
    
    fun getRoom(){
        if(residents <= capacity){
            residents++
        	println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
        
    }
    
    abstract fun floorArea() : Double 
    
    
}// End Dwelling Class 


// Subclasses 
class SqaureCabin(residents : Int, val length : Double) : Dwelling(residents) {
    
    override val buildingMaterial = "Wood"
    override val capacity = 6
    
    
    override fun floorArea() : Double {
        return length * length
    }
}


open class RoundHut(
    residents : Int,
    val radius : Double) : Dwelling(residents){
    
    override val buildingMaterial = "Straw"
    override val capacity = 3
    
    override fun floorArea() : Double {
        return PI * radius * radius
    }

}


class RoundTower(
    residents : Int,
    radius : Double, 
	val floors : Int = 2) : RoundHut(residents, radius){ // floor default value = 2 
    
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    
    override fun floorArea() : Double {
        return super.floorArea() * floors
    }
    
}
