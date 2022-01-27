object Main {

  def main(args: Array[String]) = {

    def generator: Iterator[(Int, Int)] = for {
      i <- Iterator.from(1)
      j <- 1 until i + 1 if i % j == 0
    } yield (i, j)

    println("20 elementów (take): ")
    generator take(20) foreach println


    println("20 elementów (next): ")
    val bufferedIter = generator.buffered

    for (i <- 0 until 20) {
      println(bufferedIter.next())
    }






  }

}
