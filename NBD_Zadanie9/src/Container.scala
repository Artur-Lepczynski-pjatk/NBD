class Container [A](private val watrosc: A){

  def getWartosc(): A = {
    watrosc
  }

  def applyFunction[R](fun: A => R): R = {

    fun(getWartosc())

  }



}
