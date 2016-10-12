name := "checkout"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

logBuffered in Test := false

coverageEnabled := true

mainClass in (Compile, run) := Some("checkout.Main")