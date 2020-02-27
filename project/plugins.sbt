logLevel := Level.Warn

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"

addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.9.5")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.0.0-RC5")

