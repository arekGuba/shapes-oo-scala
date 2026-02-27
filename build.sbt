name := "shapes-oo-scala"

version := "0.4"

scalaVersion := "3.7.3"

// use Scala 3 with significant indentation and helpful warnings
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xfatal-warnings",
  "-Wconf:cat=deprecation:warning",
  "-Yexplicit-nulls"
).distinct

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle"     % "0.32.0",
  "org.scalatest"     %% "scalatest"  % "3.2.19"  % Test,
  "org.scalacheck"    %% "scalacheck" % "1.19.0"  % Test,
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "ch.qos.logback" % "logback-classic" % "1.5.3"
)
