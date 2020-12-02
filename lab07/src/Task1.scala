object Task1 {
  def main(args: Array[String]): Unit = {
    val tc = new TripleContainer(1,3,5);
    println(tc)
    val sss = new TripleContainer(new SContainer("k1"), new SContainer("k2"), new SContainer("k3"))
    println(sss)
    val sis = new TripleContainer(new SContainer("k1"), new ItoSContainer(67), new SContainer("k3"))
    println(sis)
    val iii = new TripleContainer(new ItoSContainer(88765), new ItoSContainer(67), new ItoSContainer(78))
    println(iii)
    val iis = sis._1(new ItoSContainer(1))
    println(iis)
    val iss = iis._2(new SContainer("One"))
    println(iss)
    val isi = iss._3(new ItoSContainer(3))
    println(isi)
  }
}

class SContainer(val str : String){
  override def toString: String = str
}
class ItoSContainer(val num: Int) extends SContainer(num.toString) {}
class TripleContainer[+T](val arg : (T,T,T)){
  override def toString: String = arg._1.toString + " " + arg._2.toString + " " + arg._3.toString
  def _1(obj : SContainer) = new TripleContainer(obj,arg._2,arg._3)
  def _2(obj : SContainer) = new TripleContainer(arg._1,obj,arg._3)
  def _3(obj : SContainer) = new TripleContainer(arg._1,arg._2,obj)
}

