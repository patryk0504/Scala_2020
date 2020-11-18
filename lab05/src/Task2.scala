object Task2 {
  def main(args: Array[String]):Unit = {

    val s = new EquationSolver()
    println(s)
    s << Addition(1) << Subtraction(1)
    println(s)
    s << Division(0)
    println(s)
    s << Addition(1) << Multiplication(5)
    println(s)
    s << Division(2)
    println(s)
    s << List[Int](1)
    println(s)
  }
}


class EquationSolver(var result : Double = 0.0){
  def <<(eqObj: AnyRef): EquationSolver = {
    eqObj match {
      case add : Addition => result = result + add.x; println("Adding " + add.x)
      case sub : Subtraction => result = result - sub.x; println("Subtracting " + sub.x)
      case div : Division if div.x != 0.0 => result = result / div.x; println("Dividing by " + div.x)
      case mul : Multiplication => result = result * mul.x; println("Multiplying by " + mul.x)
      case _ => println("Unknown / not allowed operation")
    }
    this
  }
  override def toString: String = {"Result: " + result.toString}
}


abstract class Equation
case class Addition(x : Double) extends Equation
case class Subtraction(x : Double) extends Equation
case class Division(x : Double) extends Equation
case class Multiplication(x : Double) extends Equation