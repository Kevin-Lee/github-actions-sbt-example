import ProjectInfo._
import org.scoverage.coveralls.Imports.CoverallsKeys.coverallsTokenFile

ThisBuild / scalaVersion     := ProjectScalaVersion
ThisBuild / version          := ProjectVersion
ThisBuild / organization     := "kevinlee"
ThisBuild / crossScalaVersions := CrossScalaVersions
ThisBuild / developers   := List(
      Developer("Kevin-Lee", "Kevin Lee", "kevin.code@kevinlee.io", url("https://github.com/Kevin-Lee"))
    )

lazy val sbtGitHubActionsExample = (project in file("."))
  .enablePlugins(DevOopsScalaPlugin, DevOopsGitReleasePlugin)
  .settings(
    name := "sbt-github-actions-example"
  , description  := "GitHub Actions for sbt project"
  , resolvers ++= Seq(
        Resolver.sonatypeRepo("releases")
      , Deps.hedgehogRepo
      )
  , libraryDependencies ++= Deps.hedgehogLibs
//  , testFrameworks ++= Seq(TestFramework("hedgehog.sbt.Framework"))

  /* Bintray { */
//  , bintrayPackageLabels := Seq("Scala", "sbt", "GitHub", "GitHub Actions")
//  , bintrayVcsUrl := Some("""git@github.com:Kevin-Lee/sbt-github-actions-example.git""")
//  , licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
  /* } Bintray */


  /* Coveralls { */
//  , coverageHighlighting := (CrossVersion.partialVersion(scalaVersion.value) match {
//    case Some((2, 10)) =>
//      false
//    case _ =>
//      true
//  })
//  , coverallsTokenFile := Option(s"""${Path.userHome.absolutePath}/.coveralls-credentials""")
  /* } Coveralls */
)
