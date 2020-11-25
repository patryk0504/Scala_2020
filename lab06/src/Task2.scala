object Task2 {
  def main(args: Array[String]): Unit = {
    val g = new Grosz
    val z = new Zlotowka

    val pe = new Penny
    val po = new Pound

    val polishCashieer = new PolishCashieer("Ania")
    val englishCashieer = new EnglishCashieer("John")

    polishCashieer.getPayment(g)
    polishCashieer.getPayment(z)

//     polishCashieer.getPayment(pe) // when uncommented - compilation error
//     polishCashieer.getPayment(po) // when uncommented - compilation error

    englishCashieer.getPayment(pe)
    englishCashieer.getPayment(po)

//     englishCashieer.getPayment(g) // when uncommented - compilation error
//     englishCashieer.getPayment(z) // when uncommented - compilation error
  }
  abstract class Currency

  trait BritishCurrency extends Currency  {def str = "GBP"}
  trait PolishCurrency extends Currency {def str = "PLN"}

  class Grosz extends PolishCurrency {  override def str: String = "grosz " + super.str}
  class Zlotowka extends PolishCurrency {   override def str: String = "zlotowka " + super.str}

  class Penny extends BritishCurrency{    override def str: String = "Penny " + super.str }
  class Pound extends BritishCurrency{    override def str: String = "Pound " + super.str }

  abstract class Chashier{
    type appType <: Currency
    def getPayment(obj : appType) : Unit
  }

  class PolishCashieer(name: String) extends Chashier {
    type appType = PolishCurrency
    override def getPayment(obj: PolishCurrency): Unit = {println("Zaplacono pracownikowi " + name + ": "  + obj.str)}
  }

  class EnglishCashieer(name: String) extends Chashier {
    type appType = BritishCurrency
    override def getPayment(obj: BritishCurrency): Unit = {println("Zaplacono pracownikowi " + name + ": "  + obj.str)}
  }
}
