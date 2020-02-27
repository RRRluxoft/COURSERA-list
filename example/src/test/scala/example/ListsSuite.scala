package example

import org.scalatest.{FunSuite, Matchers}

/**
  * This class implements a ScalaTest test suite for the methods in object
  * `Lists` that need to be implemented as part of this assignment. A test
  * suite is simply a collection of individual tests for some specific
  * component of a program.
  *
  * A test suite is created by defining a class which extends the type
  * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
  * find this class and execute all of its tests.
  * There's is a plenty of specs available, like `FlatSpec` or `FunSpec`
  * the choice is a matter of taste.
  *
  * You may find more detailed information here:
  * http://www.scalatest.org/user_guide
  *
  * - Start the sbt console and run the "test" command
  * - Right-click this file in your IDEA and chose "Run"
  */
class ListsSuite extends FunSuite with Matchers {

  /**
    * Tests are written using the `test` operator which takes two arguments:
    *
    * - A description of the test. This description has to be unique, no two
    *   tests can have the same description.
    * - The test body, a piece of Scala code that implements the test
    *
    * The most common way to implement a test body is using the method `assert`
    * which tests that its argument evaluates to `true`. So one of the simplest
    * successful tests is the following:
    */
  test("one plus one is two")(assert(1 + 1 == 2))

  /**
    * In Scala, it is allowed to pass an argument to a method using the block
    * syntax, i.e. `{ argument }` instead of parentheses `(argument)`.
    *
    * This allows tests to be written in a more readable manner:
    */
  test("one plus one is three?") {
    assert(1 + 1 == 2) // This assertion fails! Go ahead and fix it.
  }

  /**
    * One problem with the previous (failing) test is that ScalaTest will
    * only tell you that a test failed, but it will not tell you what was
    * the reason for the failure. The output looks like this:
    *
    * {{{
    *    [info] - one plus one is three? *** FAILED ***
    * }}}
    *
    * This situation can be improved by using a special equality operator
    * `===` instead of `==` (this is only possible in ScalaTest). So if you
    * run the next test, ScalaTest will show the following output:
    *
    * {{{
    *    [info] - details why one plus one is not three *** FAILED ***
    *    [info]   2 did not equal 3 (ListsSuite.scala:67)
    * }}}
    *
    * We recommend to stick with `===` equality operator when writing tests.
    */
  test("details why one plus one is not three") {
    assert(1 + 1 === 2) // Fix me, please!
  }

  /**
    * In order to test the exceptional behavior of a methods, ScalaTest offers
    * the `intercept` operation.
    *
    * In the following example, we test the fact that the method `intNotZero`
    * throws an `IllegalArgumentException` if its argument is `0`.
    */
  test("intNotZero throws an exception if its argument is 0") {
    intercept[IllegalArgumentException] {
      intNotZero(0)
    }
  }

  def intNotZero(x: Int): Int = {
    if (x == 0) throw new IllegalArgumentException("zero is not allowed")
    else x
  }

  /**
    * Scala test also provides you with matchers that allow you
    * to write more readable and text-like specifications
    * You may find more info about them here:
    * http://www.scalatest.org/user_guide/using_matchers#checkingEqualityWithMatchers
    */
  test("now, with matchers") {
    // Scala allows some weird variable names
    // Yep, `2 + 2` is the name of variable
    // And you shouldn't use names like those except cases when
    // you make your own DSL
    val `2 + 2` = 2 + 2

    // And you must fix that either
    `2 + 2` should equal(4)
    `2 + 2` should be(4)
    `2 + 2` should ===(4)
  }

  /**
    * Now we finally write some tests for the list functions that have to be
    * implemented for this assignment. We fist import all members of the
    * `List` object.
    */
  import Lists._

  /**
    * We only provide two very basic tests for you. Write more tests to make
    * sure your `length` and `min` methods work as expected.
    *
    * In particular, write tests for corner cases: negative numbers, zeros,
    * empty lists, lists with repeated elements, etc.
    *
    * It is allowed to have multiple `assert`/ matchers statements inside one test,
    * however it is recommended to write an individual `test` statement for
    * every tested aspect of a method.
    */
  // Length
  test("length of the list") {
    val testList = List(1, 2, 0)
    countElements(testList) should ===(3)
  }

  test("long list length") {
    val testList = (1 to 100000).toList
    countElements(testList) should ===(100000)
  }

  // Min
  test("min of a few numbers") {
    min(List(3, 2, 7)) should ===(Some(2))
  }

  test("long list min") {
    val testList = (1 to 100000).toList
    min(testList) shouldBe Some(1)
  }

  test("return an empty option for empt list") {
    min(List.empty) should ===(None)
  }

  // Sum
  test("sum of empty element list must be 0") {
    sum(List.empty) should ===(0L)
  }

  test("sum of the first 10 natural numbers") {
    val testList = (1 to 10).toList
    sum(testList) should ===(55L)
  }

  // mkString
  test("pretty-print empty list") {
    mkString(List.empty) should ===("List()")
  }

  test("pretty-print non-empty list") {
    val nonEmptyList = (1 to 10).toList
    mkString(nonEmptyList) should be("List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)")
  }
}
