class KontoBankowe (poczatkowyStanKonta: Double){

  private var _stanKonta: Double = poczatkowyStanKonta

  def stanKonta: Double = _stanKonta

  def this(){
    this(0)
  }

  def wplata(kwota: Double): Boolean = {
    if(kwota > 0){
      _stanKonta += kwota
      true
    }else{
      println("Nie można wpłacic kwoty <= 0!")
      false
    }
  }

  def wyplata(kwota: Double): Boolean = {
    if(_stanKonta >= kwota){
      _stanKonta -= kwota
      true
    }else{
      println("Na koncie nie ma wystarczających środków!")
      false
    }



  }



}
