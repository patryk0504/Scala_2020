object Task2 {
  def main(args: Array[String]): Unit = {
    val coord1 = (0,0)
    val coord2 = (10,10)

    //upel test
    val listOfPoints = List((0,0), (1,1), (10,10),(11,0),(0,11))//,(1,1),(-1,-1))
    println("Number of points inside rectangle is " + howManyPoints(listOfPoints,coord1,coord2,0))
  }

  def isInside(leftBottomCorner: (Int, Int), rightTopCorner: (Int, Int), point: (Int, Int)): Boolean = {
    point._1 >= leftBottomCorner._1 && point._2 >= leftBottomCorner._2 && point._1 <= rightTopCorner._1 && point._2 <= rightTopCorner._2
  }

  @scala.annotation.tailrec
  def howManyPoints(list : List[(Int,Int)],leftBottomCorner : (Int, Int), rightTopCorner : (Int, Int), counter : Int): Int ={
    if(list.length < 1)
      return counter
    val newCounter = if( isInside(leftBottomCorner,rightTopCorner,list.head) ) counter+1 else counter
    howManyPoints(list.tail,leftBottomCorner,rightTopCorner,newCounter)
  }

}