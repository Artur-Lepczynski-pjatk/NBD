object Main {


  def main(args: Array[String]): Unit = {

    //-------- zadanie 1 --------

    def zad1(dzien: String): String = {

      val dniPowszednie = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek")
      val dniWolne = List("Sobota", "Niedziela")

      dzien match {
        case a if (dniPowszednie.contains(a)) => "Praca"
        case b if (dniWolne.contains(b)) => "Weekend"
        case _ => "Nie ma takiego dnia"
      }
    }

    println("--- Zadanie 1: ")
    println("Czwartek: " + zad1("Czwartek"))
    println("Sobota: " + zad1("Sobota"))
    println("Szóstek: " + zad1("Szóstek") + "\n")


    //-------- zadanie 2 --------

    println("--- Zadanie 2: ")

    val kontoBankowe1 = new KontoBankowe()
    println("Stan konta 1: " + kontoBankowe1.stanKonta)
    kontoBankowe1.wplata(1234)
    println("Stan konta 1 po wpłacie: " + kontoBankowe1.stanKonta)

    val kontoBankowe2 = new KontoBankowe(200)
    println("Stan konta 2: " + kontoBankowe2.stanKonta)
    kontoBankowe2.wyplata(100)
    println("Stan konta 2 po wypłacie: " + kontoBankowe2.stanKonta + "\n")


    //-------- zadanie 3 --------


    val osoba1 = new Osoba("Jan", "Kowalski")
    val osoba2 = new Osoba("Asia", "Jakaś")
    val osoba3 = new Osoba("Arkadiusz", "Nowak")
    val osoba4 = new Osoba("Tytus", "Woźniak")

    def zad3(osoba: Osoba) = {

      val przywitanie = osoba match {
        case Osoba("Jan", "Kowalski") => "Dzień dobry, mam na imie Jan"
        case Osoba("Asia", "Jakaś") => "Cześć, jestem Asia!"
        case Osoba("Arkadiusz", "Nowak") => "Witam, nazywam się Arek"
        case _ => "Witam, Jestem kimś innym..."
      }
      przywitanie
    }

    println("--- Zadanie 3: ")
    println(zad3(osoba1))
    println(zad3(osoba2))
    println(zad3(osoba3))
    println(zad3(osoba4) + "\n")

    //-------- zadanie 4 --------

    def plus10(liczba: Int) = {
      liczba + 10
    }

    val liczba = 10

    def zad4(liczba: Int, fun: (Int) => Int): Int = {
      fun(fun(fun(liczba)))
    }

    println("--- Zadanie 4: ")
    println("Liczba przed: " + liczba)
    println("Liczba po: " + zad4(liczba, plus10) + "\n")

    //-------- zadanie 5 --------

    //w tym zadaniu wymagana klasa Osoba nazywa się OsobaZad5, ponieważ klasa osoba powstała już w zadaniu 3

    println("--- Zadanie 5: ")

    val osoba5 = new OsobaZad5("a", "b", 50) with Student
    println("Podatek podany: 100 - Podatek studenta: " + osoba5.podatek)

    val osoba6 = new OsobaZad5("a", "b", 50) with Pracownik
    println("Podatek podany: 50 - Podatek Pracownika: " + osoba6.podatek)

    val osoba7 = new OsobaZad5("a", "b", 20) with Nauczyciel
    println("Podatek podany: 20 - Podatek Nauczyciela: " + osoba7.podatek)


    val osoba8 = new OsobaZad5("a", "b", 100) with Student with Pracownik
    println("Podatek podany: 100 - Podatek Studenta - nauczyciela: " + osoba8.podatek)

    val osoba9 = new OsobaZad5("a", "b", 100) with Pracownik with Student
    println("Podatek podany: 100 - Podatek Nauczyciela - Studenta: " + osoba9.podatek)





















  }

}
