package streams

import org.scalatest.FlatSpec

class BloxorzSuite extends FlatSpec {

  /**
    * Testing fixture
    */
  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {

    /**
      * This method applies a list of moves `ls` to the block at position
      * `startPos`. This can be used to verify if a certain list of moves
      * is a valid solution, i.e. leads to the goal.
      */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) {
        case (block, move) =>
          move match {
            case Left  => block.left
            case Right => block.right
            case Up    => block.up
            case Down  => block.down
          }
      }
  }

  trait Level1 extends SolutionChecker {
    /* terrain for level 1*/

    val level: String =
      """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  "level 1" should "have terrain function working" in new Level1 {
    assert(terrain(Pos(0, 0)), "0,0")
    assert(!terrain(Pos(4, 11)), "4,11")
  }

  "level 1" should "have findChar working" in new Level1 {
    assert(startPos == Pos(1, 1))
  }

  "level 1" should "have optimal solution" in new Level1 {
    assert(solve(solution) == Block(goal, goal))
  }

  "level 1" should "have optimal solution length" in new Level1 {
    assert(solution.length == optsolution.length)
  }
}
