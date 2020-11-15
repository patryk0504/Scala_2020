object Task1 {

  def main(args: Array[String]): Unit = {

    if(args.length < 2)
      println("Please provide two arguments")
    else if(!args(0).charAt(0).isLetter || !args(1).charAt(0).isLetter)
      println("Please provide only letters")
    else{
      val first = args(0).charAt(0).toLower
      val second = args(1).charAt(0).toLower

      if(first < second) {
        val gen = first to second
        gen.foreach(println)
      }else{
        val gen = second to first
        gen.foreach(println)
      }
    }
  }

}
