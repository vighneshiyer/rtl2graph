ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0"
ThisBuild / organization     := "edu.berkeley.cs"

val chiselVersion = "3.5.4"

lazy val root = (project in file("."))
  .settings(
    name := "rtl2graph",
    libraryDependencies ++= Seq(
      "edu.berkeley.cs" %% "chisel3" % chiselVersion,
      "edu.berkeley.cs" %% "chiseltest" % "0.5.4" % "test"
    ),
    scalacOptions ++= Seq(
      "-language:reflectiveCalls",
      "-deprecation",
      "-feature",
      "-Xcheckinit",
    ),
    addCompilerPlugin("edu.berkeley.cs" % "chisel3-plugin" % chiselVersion cross CrossVersion.full),
    Compile / scalaSource := baseDirectory.value / "src",
    Compile / resourceDirectory := baseDirectory.value / "src" / "resources",
    Test / scalaSource := baseDirectory.value / "test",
    Test / resourceDirectory := baseDirectory.value / "test" / "resources",
  )
libraryDependencies += "org.jgrapht" % "jgrapht-core" % "1.5.1"