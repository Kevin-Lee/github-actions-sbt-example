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
  .enablePlugins(DevOopsScalaPlugin)
  .settings(
    name := "github-actions-sbt-example"
  , description  := "GitHub Actions for sbt project"
  , resolvers ++= Seq(
        Resolver.sonatypeRepo("releases")
      , Deps.hedgehogRepo
      )
  , libraryDependencies ++= Deps.hedgehogLibs
  , testFrameworks ++= Seq(TestFramework("hedgehog.sbt.Framework"))

  /* Bintray { */
//  , bintrayPackageLabels := Seq("Scala", "sbt", "GitHub", "GitHub Actions")
//  , bintrayVcsUrl := Some("""git@github.com:Kevin-Lee/sbt-github-actions-example.git""")
//  , licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
  /* } Bintray */


  /* Coveralls { */
  /* Don't for get to add COVERALLS_REPO_TOKEN in your project's secrets
   * Project => Settings => Secrets
   * https://help.github.com/en/articles/virtual-environments-for-github-actions#creating-and-using-secrets-encrypted-variables
   */
  , coverageHighlighting := (CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((2, 10)) =>
      false
    case _ =>
      true
  })
  /* } Coveralls */
)
