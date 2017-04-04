lazy val commonSettings = Seq(
  organization := "com.bayakala"
  , version := "1.0.0-RC-01"
  , resolvers ++= Seq(
    Resolver.mavenLocal
    , Resolver.sonatypeRepo("releases")
    , Resolver.sonatypeRepo("snapshots"))
  , scalaVersion := "2.11.8"
//  , crossScalaVersions := Seq("2.11.8", "2.12.0", "2.12.1")
  , bintrayOrganization := Some("bayakala")
  , licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
)

def scalacOptionsVersion(scalaVersion: String) = {
  Seq(
    "-feature"
    ,"-deprecation"
  ) ++ (CrossVersion.partialVersion(scalaVersion) match {
    case Some((2, scalaMajor)) if scalaMajor == 12 => Seq("-Ypartial-unification")
    case _ => Nil
  })
}

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    name := "funda",
    scalacOptions ++= scalacOptionsVersion(scalaVersion.value)
  )
  .settings(
    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % "3.2.0",
      "com.h2database" % "h2" % "1.4.191",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0",
      "ch.qos.logback" % "logback-classic" % "1.1.7",
      "co.fs2" %% "fs2-core" % "0.9.4",
      "co.fs2" %% "fs2-io" % "0.9.4",
      "com.typesafe.play" % "play-iteratees-reactive-streams_2.11" % "2.6.0"
    )
  )





