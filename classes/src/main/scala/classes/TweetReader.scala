package classes

import org.json4s.native.JsonMethods._
import org.json4s.{DefaultFormats, _}

object TweetReader {

  implicit val formats: DefaultFormats = new Object with DefaultFormats

  def getTweets(json: String): List[Tweet] = parse(json).extract[List[Tweet]]

  def toTweetSet(l: List[Tweet]): TweetSet = l.foldLeft(new Empty: TweetSet)(_.incl(_))

  def unparseToData(tws: List[Tweet]): String = {
    val buf = new StringBuilder
    for (tw <- tws) {
      val json = "{ \"user\": \"" + tw.user + "\", \"text\": \"" +
        tw.text.replaceAll(""""""", "\\\\\\\"") + "\", \"retweets\": " +
        tw.retweets + ".0 }"
      buf.append(json + ",\n")
    }
    buf.toString()
  }

  val sites =
    List("gizmodo", "TechCrunch", "engadget", "amazondeals", "CNET", "gadgetlab", "mashable")

  private val gizmodoTweets     = getTweets(TweetData.gizmodo)
  private val techCrunchTweets  = getTweets(TweetData.TechCrunch)
  private val engadgetTweets    = getTweets(TweetData.engadget)
  private val amazondealsTweets = getTweets(TweetData.amazondeals)
  private val cnetTweets        = getTweets(TweetData.CNET)
  private val gadgetlabTweets   = getTweets(TweetData.gadgetlab)
  private val mashableTweets    = getTweets(TweetData.mashable)

  private val sources = List(
    gizmodoTweets,
    techCrunchTweets,
    engadgetTweets,
    amazondealsTweets,
    cnetTweets,
    gadgetlabTweets,
    mashableTweets
  )

  val tweetMap: Map[String, List[Tweet]] =
    Map.empty ++ Seq(
      sites(0) -> gizmodoTweets,
      sites(1) -> techCrunchTweets,
      sites(2) -> engadgetTweets,
      sites(3) -> amazondealsTweets,
      sites(4) -> cnetTweets,
      sites(5) -> gadgetlabTweets,
      sites(6) -> mashableTweets
    )

  val tweetSets: List[TweetSet] = sources.map(toTweetSet)

  private val siteTweetSetMap: Map[String, TweetSet] =
    Map.empty ++ (sites zip tweetSets)

  private def unionOfAllTweetSets(curSets: List[TweetSet], acc: TweetSet): TweetSet =
    if (curSets.isEmpty) acc
    else unionOfAllTweetSets(curSets.tail, acc.union(curSets.head))

  val allTweets: TweetSet = unionOfAllTweetSets(tweetSets, new Empty)
}
