import scala.io.Source.fromInputStream

package object forcomp {
  val dictionaryPath = List("forcomp", "linuxwords.txt")

  def loadDictionary: List[String] = {
    val wordStream = Option {
      getClass.getClassLoader.getResourceAsStream(dictionaryPath.mkString("/"))
    }.orElse {
        utils.resourceAsStreamFromSrc(dictionaryPath)
      }
      .getOrElse {
        sys.error("Could not load word list, dictionary file not found")
      }

    try fromInputStream(wordStream).getLines().toList
    catch {
      case e: Exception =>
        println("Could not load word list: " + e)
        throw e
    } finally {
      wordStream.close()
    }
  }

}
