//import AssemblyKeys._

//assemblySettings

//mainClass in assembly := Some("lms.parsing.Bla")

name := "experiments"

scalaOrganization := "org.scala-lang.virtualized"

scalaVersion := "2.10.2-RC1"

resolvers ++= Seq(
  ScalaToolsSnapshots, //needed for custom build of scala test
  "ScalaTest" at "https://oss.sonatype.org/content/groups/public",
  "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
)

libraryDependencies ++= Seq(
  "EPFL" %% "lms" % "0.3-SNAPSHOT",
  //"org.scala-lang" % "scala-actors" % "2.10.0", // for ScalaTest
  "org.scalatest" %% "scalatest" % "2.0.RC3" % "test",
  //"org.scalatest" % "scalatest_2.10.0" % "2.0.M5" % "test"
  "commons-codec" % "commons-codec" % "1.6",
  "com.github.axel22" %% "scalameter" % "0.4-M2" excludeAll (ExclusionRule(organization = "org.scala-lang"))
)

autoCompilerPlugins := true

addCompilerPlugin("org.scala-lang.virtualized.plugins" % "continuations" % "2.10.2-RC1")

scalacOptions ++= Seq(
  "-Yvirtualize",
  "-P:continuations:enable",
  "-optimize",
  "-deprecation",
  "-feature",
  "-Yinline-warnings"
)

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")

//avoid testing during assembly
//test in assembly := {}
