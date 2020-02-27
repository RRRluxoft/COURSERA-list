package functions

object RecursiveFunctions {

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = ???

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = ???

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = ???

  /**
    * Runs as app and prints the triangle, generated
    * by `pascal` function that you should iplemet first
    * @param args
    */
  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

}
