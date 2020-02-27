package lists

import org.scalatest.{FunSuite, Matchers}

/**
  * This class implements a ScalaTest test suite for the methods in object
  * `MaximumPathSum` that need to be implemented as part of this assignment. A test
  * suite is simply a collection of individual tests for some specific
  * component of a program.
  *
  * A test suite is created by defining a class which extends the type
  * `org.scalatest.FunSuite`. When running ScalaTest, it will automatically
  * find this class and execute all of its tests.
  */
class MaximumPathSumSuite extends FunSuite with Matchers {

  import ProblemData._
  import ProblemSolver._

  test("empty data") {
    val paths    = findOptimalPaths(Nil)
    val bestPath = chooseBestPath(paths)
    bestPath should be('defined)
    bestPath.get.sum should ===(0)
    bestPath.get should ===(List())
  }

  test("one number problem") {
    val paths    = findOptimalPaths(List(List(42)))
    val bestPath = chooseBestPath(paths)

    bestPath should be('defined)
    bestPath.get.sum should ===(42)
    bestPath.get should ===(List(42))
  }

  test("sum of small problem") {
    val paths    = findOptimalPaths(small)
    val bestPath = chooseBestPath(paths)

    bestPath should be('defined)
    bestPath.get.sum should ===(23)
  }

  test("path of small problem") {
    val paths    = findOptimalPaths(small)
    val bestPath = chooseBestPath(paths)

    bestPath should be('defined)
    bestPath.get should ===(List(3, 7, 4, 9))
  }

  test("sum of medium problem") {
    val paths    = findOptimalPaths(medium)
    val bestPath = chooseBestPath(paths)

    bestPath should be('defined)
    bestPath.get.sum should ===(1074)
  }

  test("sum of large problem") {
    val paths    = findOptimalPaths(large)
    val bestPath = chooseBestPath(paths)

    bestPath should be('defined)
    bestPath.get.sum should ===(7273)
  }
}
