object Task2 {

  def areaTuple(tuple : (Double,Double)) : Double = tuple._1 * tuple._2

  def printFun(rect : (Double,Double)): Unit = println(f"(${rect._1}, ${rect._2}) => area: ${areaTuple(rect)}")

  def areaGreaterThan2(lista : List[(Double,Double)], area : Double): List[(Double,Double)] = {
    lista.filter(areaTuple(_) > area)
  }


  def main(args: Array[String]): Unit = {
    val rect1 = (2.0,2.0)
    val rect2 = (8.0,8.0)
    val rect3 = (9.0,9.0)

    val list1 = List(rect1,rect2,rect3)//1 sposob
    val list2 = rect1 :: rect2 :: rect3 :: List()//2 sposob
    val list3 = List(rect1) ++ List(rect2) ++ List(rect3)//3 sposob

    areaGreaterThan2(list1,5).foreach(printFun)
  }
}
