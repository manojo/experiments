name := "experiments"

scalaOrganization := "org.scala-lang.virtualized"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "EPFL" %% "lms" % "0.3-SNAPSHOT"
)

scalacOptions += "-Yvirtualize"
