import scala.collection.mutable.ListBuffer

object Task1 {
  def main(args: Array[String]) = {

    println(partition(list=List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), predicate=_ % 2 == 0))

    // CORRECT: List(List(2, 4, 6, 8, 10), List(1, 3, 5, 7, 9))
    // INCORRECT: List(List(10, 8, 6, 4, 2), List(9, 7, 5, 3, 1)) - result is unstabled - result lists does not have same order as list passed as argument
  }


  def partition(list: List[Int], predicate: Int => Boolean) : List[List[Int]] = {
    @scala.annotation.tailrec
    def helper(list : List[Int], trueList : ListBuffer[Int], falseList : ListBuffer[Int]) : List[List[Int]] = {
      if(list.isEmpty)
        return List(trueList.toList,falseList.toList)
      if(predicate(list.head))
        trueList.append(list.head)
      else
        falseList.append(list.head)
      helper(list.tail,trueList,falseList)
    }
    helper(list,ListBuffer[Int](), ListBuffer[Int]())
  }
}
