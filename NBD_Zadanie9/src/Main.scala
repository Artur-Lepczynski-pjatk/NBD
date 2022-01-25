object Main {

  def main(args: Array[String]) = {


    // zadanie 1:

    val container1 = new Container[Int](10)

    def Zad1fun(a: Int): Int = {
      a + 100
    }

    println("--- Zadanie 1:")
    println("Wartość kontenera: " + container1.getWartosc())
    println("wartosc po funkcji dodającej 100: " + container1.applyFunction[Int](Zad1fun) + "\n")

    // zadanie 2:

    val yes = new Yes[Int](10)
    val no = new No()

    println("--- Zadanie 2:")
    println("Obiekt yes: " + yes.isInstanceOf[Maybe[_]])
    println("Obiekt no: " + no.isInstanceOf[Maybe[_]] + "\n")

    // zadanie 3:
    println("--- Zadanie 3:")
    println("Obiekt No: " + no)
    println("applyFunction dla No: " + no.applyFunction[Int, Int](Zad1fun))

    println("Wartosc yes: " + yes.wartosc)
    println("applyFunction dla Yes: " + yes.applyFunction[Int](Zad1fun) + "\n")


    // zadanie 4:
    println("--- Zadanie 4:")
    println("Yes: " + yes.getOrElse[Int](111))
    println("No: " + no.getOrElse[Int](20))









  }

}
