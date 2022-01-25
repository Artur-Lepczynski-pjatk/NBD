class Yes [A](val wartosc: A){

  def applyFunction[R](fun: A => R): R = {
    fun(wartosc)
  }

  def getOrElse[A](wartosc2: A) = {
    wartosc
  }



}
