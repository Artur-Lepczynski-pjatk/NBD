trait Pracownik extends OsobaZad5 {

  var pensja: Double = 1000
  override val podatek: Double = pensja * 2/10

}
