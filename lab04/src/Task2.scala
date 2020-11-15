object Task2 {
  def main(args: Array[String]): Unit = {
    val x = new Formatted(0.0)
    println(x.toHuman) // Right where you are

    val y = new Formatted(5.0)
    println(y.toHuman) // In your neighborhood

    val z = new Formatted(25.0)
    println(z.toHuman) // Far away

    println(f"${z.rightWhereYouAre()} ${z.inYourNeighborhood()} ${z.farAway()}") // false false true

    val dist = new TDistance((1, 1), (4, 4)) with HumanComparator
    println(dist.toHuman) // In your neighborhood
  }
}

class Formatted(val dist : Double) extends HumanComparator{
  val distance: Double = dist
}

class TDistance(point1 : (Int, Int) = (0,0), point2 : (Int, Int) = (0,0)){
  val distance: Double = math.pow(math.pow(point2._1 - point1._1,2) + math.pow(point2._2 - point2._2,2),1/2)
}

trait HumanComparator{
  val distance : Double
  def rightWhereYouAre(): Boolean = distance == 0.0
  def inYourNeighborhood(): Boolean = (distance > 0.0 && distance < 10.0)
  def farAway(): Boolean = distance > 10.0

  def toHuman : String = {
    if(rightWhereYouAre())
      return "Right where you are"
    else if(inYourNeighborhood())
      return "In your neighborhood"
    "Far away"
  }
}