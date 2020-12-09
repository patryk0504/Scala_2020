import math.{ min, max }
object Task1 {

  def main(args: Array[String]): Unit = {
    println(unique(List(1, 1, 5, 6, 3, 5, 8, 9, 10, 8))) // List(10, 6, 9, 3)
    println(mergePairs(List(1, 5, 9, 10), List(0, 4, 10, 11), x => max(x._1, x._2))) // List(1, 5, 10, 11)
    println(mergePairs(List(1, 5, 9, 11), List(0, 4, 10, 8), x => min(x._1, x._2))) // List(0, 4, 9, 8)
  }

  //grouBy -> HashMap(key : value); if value.len == 1 <=> key is unique
  def unique(value: List[Int]) : List[Int] = {
    value.groupBy(x => x).filter(y => y._2.length == 1).keySet.toList
  }

  def mergePairs(list1: List[Int], list2: List[Int], function: ((Int, Int)) => Int): List[Int] = {
    (list1 zip list2).map {
      case (x, y) => function(x, y)
    }
  }

}
