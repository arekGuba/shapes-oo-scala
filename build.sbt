name := "shapes-oo-scala"

version := "0.4"

libraryDependencies ++= Seq(
  "org.creativescala" %% "doodle"           % "0.32.0",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "ch.qos.logback"    % "logback-classic"   % "1.5.6",
  "org.scalatest"     %% "scalatest"        % "3.2.19"  % Test,
  "org.scalacheck"    %% "scalacheck"       % "1.19.0"  % Test
)
