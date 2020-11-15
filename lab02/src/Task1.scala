object Task1 {
  def main(args: Array[String]): Unit = {
    //testy
    val equation = "22 + 2"
    println(s"Answer: ${solveEquation(equation)}")

    val equation2 = "2 - 2"
    println(s"Answer: ${solveEquation(equation2)}")

    val equation3 = "100 * 12"
    println(s"Answer: ${solveEquation(equation3)}")

    val equation4 = "40 / 2"
    println(s"Answer: ${solveEquation(equation4)}")
  }

  def add(a : Int, b : Int): Int = a + b
  def subtraction(a : Int, b : Int): Int = a - b
  def multiplication(a : Int, b : Int): Int = a * b
  def division(a : Int, b : Int): Int = a / b

  val mapFun  : Map[Char,(Int, Int) => Int] = Map('+' -> add, '-' -> subtraction, '*' -> multiplication, '/' -> division)

  def solveEquation(eq : String): Int ={
    val temp = eq.split(" ")
    val a = temp(0).toInt
    val symbol = temp(1).charAt(0)
    val b = temp(2).toInt
    mapFun(symbol)(a,b)
  }
}







//    val withoutSpace = eq.replaceAll("\\s","")
//    val symbol = withoutSpace.filter(!_.isDigit)
//    val a = withoutSpace.substring(0,withoutSpace.indexOf(symbol)).toInt
//    val b = withoutSpace.substring(withoutSpace.indexOf(symbol)+1).toInt
