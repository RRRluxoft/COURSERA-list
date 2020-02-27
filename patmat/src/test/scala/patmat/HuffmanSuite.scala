package patmat

import org.scalatest.FlatSpec
import patmat.Huffman._

/**
  * This test is using FlatSpec which is just a different approach
  * when you write unit tests
  */
class HuffmanSuite extends FlatSpec {

  /**
    * Fixture that we share between the tests
    */
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(
      Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5),
      Leaf('d', 4),
      List('a', 'b', 'd'),
      9
    )
  }

  "weight of the larger tree" should "be extracted" in new TestTrees {
    assert(weight(t1) === 5)
  }

  "chars of a larger tree" should "be extracted" in new TestTrees {
    assert(chars(t2) === List('a', 'b', 'd'))
  }

  "string2Chars" should "extract chars from \"hello, world\" swting" in {
    assert(
      string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l',
        'd')
    )
  }

  "makeOrderedLeafList" should "be built for some frequency table" in {
    assert(
      makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(
        Leaf('e', 1),
        Leaf('t', 2),
        Leaf('x', 3)
      )
    )
  }

  it should "combine of some leaf list" in {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(
      combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4))
    )
  }

  "decode and encode a very short text should be identity" should "" in new TestTrees {
    assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
  }
}
