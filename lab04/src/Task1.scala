object Task1 {
  def main(args: Array[String]): Unit = {
    val firstDistance = SDistance(2, 2, 2)
    val secondDistance = SDistance(2, 2, 2)
    val thirdDistance = SDistance(2, 2, 3)
    val fourthDistance = SDistance(2, 2, 1)

    println("Distances:")
    println(firstDistance) // Kilometers: 2, Meters : 2, Centimeters: 2
    println(secondDistance) // Kilometers: 2, Meters : 2, Centimeters: 2
    println(thirdDistance) // Kilometers: 2, Meters : 2, Centimeters: 3
    println(fourthDistance) // Kilometers: 2, Meters : 2, Centimeters: 1

    println("2:")
    println(firstDistance == secondDistance) // true
    println(firstDistance != secondDistance) // false
    println(firstDistance > secondDistance) // false
    println(firstDistance < secondDistance) // false

    println("3:")
    println(firstDistance == thirdDistance) // false
    println(firstDistance != thirdDistance) // true
    println(firstDistance > thirdDistance) // false
    println(firstDistance < thirdDistance) // true

    println("4:")
    println(firstDistance == fourthDistance) // false
    println(firstDistance != fourthDistance) // true
    println(firstDistance > fourthDistance) // true
    println(firstDistance < fourthDistance) // false

    val fifthDistance = firstDistance.add(2, SDistance.Kilometers) // here you have to be able to add also meters or centimeters
    println(fifthDistance) // Kilometers: 4, Meters: 2, Centimeters: 2
  }

}

object SDistance extends Enumeration{
  def apply(km: Int, m: Int, cm: Int): SDistance = new SDistance(km, m, cm)
  val Kilometers, Meters, Centimeters = Value
}

class SDistance(val km : Int, val m : Int, val cm : Int){
  override def toString: String = "Kilometers: " + km +", Meters : " + m + ", Centimeters: " + cm

  def !=(obj : SDistance) : Boolean = !this.==(obj)
  def ==(obj: SDistance): Boolean = {
    if(this.km != obj.km || this.m != obj.m || this.cm != obj.cm)
      return false
    true
  }

  def >(obj : SDistance) : Boolean = {
    if(this.km > obj.km)
      return true
    else if(this.m > obj.m)
      return true
    else if(this.cm > obj.cm)
      return true
    false
  }

  def <(obj : SDistance) : Boolean = {
    if(this.km < obj.km)
      return true
    else if(this.m < obj.m)
      return true
    else if(this.cm < obj.cm)
      return true
    false
  }

  def add(value : Int, metric: SDistance.Value): SDistance ={
    if(metric == SDistance.Kilometers)
      SDistance(this.km + value, this.m, this.cm)
    else if(metric == SDistance.Meters)
      SDistance(this.km, this.m + value, this.cm)
    else
      SDistance(this.km, this.m, this.cm + value)
  }
}