class No extends Maybe[Nothing]{

  def applyFunction[A,R](fun: A => R): No = {
    new No()
  }

  def getOrElse[A](wartosc: A): A = {
    wartosc
  }

  def map[A, R](fun: A => R) = {
    new No()
  }

  def flatMap[A, R](fun: A => R) = {
    new No()
  }



}
