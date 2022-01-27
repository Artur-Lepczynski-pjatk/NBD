class Yes [A](val wartosc: A){

  def applyFunction[R](fun: A => R): R = {
    fun(wartosc)
  }

  def getOrElse[A](wartosc2: A) = {
    wartosc
  }

  def map[R](fun: A => Maybe[R]) = {
    new Yes(fun(wartosc))
  }

  def flatMap[R](fun: A => Maybe[R]) = {
    fun(wartosc)
  }

}
