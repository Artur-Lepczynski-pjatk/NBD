import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`seq AsJavaList`

object Main {
  def main(args: Array[String]) = {


    //-------- zadanie 1 --------
    val dniTygodnia = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    //zadanie 1a:
    def zad1a(dniTygodnia: List[String]) = {
      var dniString = ""

      for (i <- dniTygodnia.indices) {
        if (dniString == "") {
          dniString += dniTygodnia.get(i)
        } else {
          dniString += ", " + dniTygodnia.get(i)
        }
      }
      dniString
    }

    println("--- Zadanie 1a: ")
    println(zad1a(dniTygodnia) + "\n")

    //zadanie 1b:
    def zad1b(dniTygodnia: List[String]) = {
      var dniString = ""

      for (i <- dniTygodnia.indices) {
        if (dniTygodnia.get(i).startsWith("P")) {
          if (dniString == "") {
            dniString += dniTygodnia.get(i)
          } else {
            dniString += ", " + dniTygodnia.get(i)
          }
        }
      }
      dniString
    }

    println("--- Zadanie 1b:")
    println(zad1b(dniTygodnia) + "\n")


    //zadanie 1c:
    def zad1c(dniTygodnia: List[String]) = {
      var dniString = ""
      var index = 0

      while (index < dniTygodnia.length) {
        if (dniString == "") {
          dniString += dniTygodnia.get(index)
        } else {
          dniString += ", " + dniTygodnia.get(index)
        }
        index += 1
      }

      dniString
    }

    println("--- Zadanie 1c:")
    println(zad1c(dniTygodnia) + "\n")

    //-------- zadanie 2 --------

    //zadanie 2a:
    def zad2a(dniTygodnia: List[String]) = {

      def dodanieDnia(i: Int): String = {
        if (i == dniTygodnia.length) {
          return ""
        }

        var dzien = ""

        if (i == dniTygodnia.length - 1) {
          dzien = dniTygodnia.get(i)
        } else {
          dzien = dniTygodnia.get(i) + ", "
        }

        dzien = dzien + dodanieDnia(i + 1)
        return dzien
      }

      dodanieDnia(0)
    }

    println("--- Zadanie 2a:")
    println(zad2a(dniTygodnia) + "\n")

    //zadanie 2b:
    def zad2b(dniTygodnia: List[String]) = {

      def dodanieDnia(i: Int): String = {
        if (i == -1) {
          return ""
        }

        var dzien = ""

        if (i == 0) {
          dzien = dniTygodnia.get(i)
        } else {
          dzien = dniTygodnia.get(i) + ", "
        }

        dzien = dzien + dodanieDnia(i - 1)
        return dzien
      }

      dodanieDnia(dniTygodnia.length - 1)
    }

    println("--- Zadanie 2b:")
    println(zad2b(dniTygodnia) + "\n")

    //-------- zadanie 3 --------

    def zad3(dniTygodnia: List[String]) = {

      @tailrec
      def dodanieDnia(i: Int, dniString: String): String = {
        if (i == dniTygodnia.length) {
          return dniString
        }

        var dzien = ""

        if (i == dniTygodnia.length - 1) {
          dzien = dniTygodnia.get(i)
        } else {
          dzien = dniTygodnia.get(i) + ", "
        }

        dodanieDnia(i + 1, dniString + dzien)
      }

      dodanieDnia(0, "")
    }

    println("--- Zadanie 3:")
    println(zad3(dniTygodnia) + "\n")

    //-------- zadanie 4 --------

    //zadanie 4a:
    def zad4a(dniTygodnia: List[String]): String = {

      var dniString = dniTygodnia.foldLeft("") { (A, B) => {
        A + B + ", "
      }
      }

      dniString.dropRight(2)
    }

    println("--- Zadanie 4a:")
    println(zad4a(dniTygodnia) + "\n")

    //zadanie4b:
    def zad4b(dniTygodnia: List[String]): String = {

      var dniString = dniTygodnia.foldRight("") { (A, B) => {
        A + ", " + B
      }
      }

      dniString.dropRight(2)
    }

    println("--- Zadanie 4b:")
    println(zad4b(dniTygodnia) + "\n")

    //zadanie 4c:
    def zad4c(dniTygodnia: List[String]): String = {

      var dniString = dniTygodnia.foldLeft("") { (A, B) => {
        if (B.startsWith("P")) {
          A + B + ", "
        } else {
          A
        }
      }
      }

      dniString.dropRight(2)
    }

    println("--- Zadanie 4c:")
    println(zad4c(dniTygodnia) + "\n")

    //-------- zadanie 5 --------

    var produkty = Map("ProduktA" -> 200, "ProduktB" -> 500, "ProduktC" -> 234, "ProduktD" -> 150)

    var produktyObnizka = produkty map {
      case (key, value) => (key, value * 0.9)
    }

    println("--- Zadanie 5:")
    println("przed obniżką: " + produkty)
    println("po obniżce: " + produktyObnizka + "\n")

    //-------- zadanie 6 --------

    def zad6(tuple: (Int, String, Boolean)) = {
      println(tuple._1)
      println(tuple._2)
      println(tuple._3)
    }

    println("--- Zadanie 6:")
    zad6(10, "Hello", true)
    println()

    //-------- zadanie 7 --------
    //korzystam z mapy "produkty" z zadania 5

    println("--- Zadanie 7:")
    println(produkty.get("ProduktA"))
    println(produkty.get("ProduktZ") + "\n")

    //-------- zadanie 8 --------

    def zad8(liczby: List[Int]): List[Int] = {

      def EvalElem(index: Int, liczby: List[Int]): List[Int] = {

        if (index >= liczby.length) {
          return liczby
        }

        val (split1, split2) = liczby.splitAt(index)

        if (liczby.get(index) == 0) (
          return EvalElem(index + 1, split1 ++ split2.tail)
          ) else {
          return EvalElem(index + 1, liczby)
        }

      }

      EvalElem(0, liczby)
    }

    val liczby = List(1, 0, 2, 0, 3, -4, 0)

    println("--- Zadanie 8:")
    println("liczby: " + liczby)
    println("liczby bez 0: " + zad8(liczby) + "\n")

    //-------- zadanie 9 --------

    def zad9(liczby: List[Int]): List[Int] = {
      return liczby map (elem => elem + 1)
    }

    val liczby2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("--- Zadanie 9:")
    println("przed: " + liczby2)
    println("po: " + zad9(liczby2) + "\n")

    //-------- zadanie 10 --------

    def zad10(liczby: List[Int]): List[Int] = {
      val liczby2 = liczby filter (elem => elem >= -5 && elem <= 12)

      liczby2 map (elem => elem.abs)
    }

    val liczby3 = List(-30, -20, -5, -3, 0, 5, 10, 12, 20, 300)

    println("--- Zadanie 10:")
    println("przed: " + liczby3)
    println("po: " + zad10(liczby3) + "\n")

  }
}
