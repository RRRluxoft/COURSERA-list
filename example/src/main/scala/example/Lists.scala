package example

/**
  * For this example assignment you can use the following methods in class
  * `List`:
  *
  *  - `xs.isEmpty: Boolean` returns `true` if the list `xs` is empty
  *  - `xs.head: Int` returns the head element of the list `xs`. If the list
  *    is empty an exception is thrown
  *  - `xs.tail: List[Int]` returns the tail of the list `xs`, i.e. the the
  *    list `xs` without its `head` element
  *
  *
  *    The task assumes that you won't use loops of any kinds and use
  *    recursion + pattern matching instead
  *
  *        * ''Hint:'' Again, think of a recursive solution combined with pattern matching,
  * instead of using loop constructs.
  * In some cases, you might need to define an auxiliary method inside given function
  * to handle recursion, well. Yes, Scala supports nested functions.
  */
object Lists {

  /**
    * Computes the length of the list xs.
    *
    * @param xs a list of natural numbers
    * @return the length of the given list
    */
  def countElements(xs: List[Int]): Int = ???

  /**
    * Returns the smallest element given list of integers, if given
    * list `xs` is not empty. Returns empty option otherwise
    *
    * @param xs a list of natural numbers
    * @return the smallest element in list
    */
  def min(xs: List[Int]): Option[Int] = ???

  /**
    * Returns the sum of given list elements, you may use
    * recursion, but we advice you to use `fold` instead
    * @param xs a list of natural numbers
    * @return a sum of list elements
    */
  def sum(xs: List[Int]): Long = ???

  /**
    * Returns a pretty printed list of integers
    * @param xs a list of natural numbers
    * @return a string with all elements, separated by comma and whitespace `, `
    *
    * So, for
    *   val xs = List(1,2,3,4)
    *
    * it should return:
    *   res0: String = "List(1, 2, 3, 4)"
    *
    *  and for an empty list:
    *    res1: String = "List()"
    *
    *
    * 'Hint' use built in functions: List.map, and List.fold
    *
    * Don't use List.mkString here :)
    */
  def mkString(xs: List[Int]): String = ???

}
