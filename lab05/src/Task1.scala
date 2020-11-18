object Task1 {
  def main(args: Array[String]): Unit = {

    val firstMcSet = new NormalMcSet with BigMac with Fries with Coke
    val firstMcSetLarge = new LargeMcSet with BigMac with Fries with Coke
    val secondMcSet = new LargeMcSet with McWrap with Fries

    println(firstMcSet.name + " " + firstMcSet.price)
    println(firstMcSetLarge.name + " " + firstMcSetLarge.price)
    println(secondMcSet.name + " " + secondMcSet.price)
  }

  trait Set{
    def name() : String = {"McSet with "}
    def price() : Double
    val largeOrNormal : String
    val newPrice : Double
  }

  class NormalMcSet extends Set{
    override def name() : String = {super.name()}
    override def price(): Double = {0}
    override val largeOrNormal: String = "normal"
    override val newPrice: Double = 1.0
  }

  class LargeMcSet extends Set{
    override def name() : String = {super.name()}
    override def price() : Double = {0}
    override val largeOrNormal: String = "large"
    override val newPrice: Double = 1.5
  }

  trait BigMac extends Set{
    abstract override def name() : String= {super.name() + " BigMac "}
    abstract override def price(): Double = {10.0}
  }

  trait McWrap extends Set{
    abstract override def name() : String = {super.name() + " McWrap "}
    abstract override def price(): Double = { 9.0}
  }

  trait Fries extends Set {
    abstract override def name() : String= {super.name() + largeOrNormal + " fries " }
    abstract override def price(): Double = {super.price()  + newPrice * 5.0}
  }

  trait Coke extends Set{
    abstract override def name() : String= {super.name() + largeOrNormal + " coke " }
    abstract override def price(): Double = {super.price() + newPrice * 4.0}
  }



}
