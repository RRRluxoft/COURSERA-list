
organization := "com.dataart"
name := "scala-101"
version := "1.1.0"


// Compiler options
val compilerOptions = Seq(
  "-deprecation",
  "-feature",
  "-Ywarn-unused-import",
  "-Yrangepos"                // required by SemanticDB compiler plugin (Scalafix)
)


// Use fix command to run the linter
addCommandAlias("fix", "all compile:scalafix test:scalafix")


// Dependencies
// Test
val testDependencies = Seq(
  "org.scalactic" %% "scalactic" % "3.0.5" % "test",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
)


val commonSettings = Seq(
  scalaVersion := "2.12.8",
  scalacOptions ++= compilerOptions,
  scalafmtOnCompile := true,
  libraryDependencies ++= testDependencies,

//  addCompilerPlugin(scalafixSemanticdb)
)


// The project that contains intercourse dependencies
// All chapters should depend on it
lazy val utils = project.in(file("./utils")).settings(commonSettings)



// Projects

lazy val example =
  project.dependsOn(utils % "compile->compile;test->test")
    .settings(commonSettings)

lazy val functions =
  project.dependsOn(utils % "compile->compile;test->test")
    .settings(commonSettings)

lazy val classes =
  project.dependsOn(utils % "compile->compile;test->test")
    .settings(
      commonSettings,
      libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.5")

lazy val patmat =
  project.dependsOn(utils % "compile->compile;test->test")
    .settings(commonSettings)

lazy val lists =
  project.dependsOn(utils % "compile->compile;test->test")
    .settings(commonSettings)

lazy val forcomp =
  project.dependsOn(utils % "compile->compile;test->test")
    .settings(commonSettings)

lazy val streams =
  project.dependsOn(utils % "compile->compile;test->test")
    .settings(commonSettings)

lazy val root =
  project.in(file(".")).aggregate(
    example,
    functions,
    classes,
    patmat,
    lists,
    forcomp,
    streams
  )
