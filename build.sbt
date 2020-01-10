import ProjectInfo._

ThisBuild / scalaVersion     := ProjectScalaVersion
ThisBuild / version          := ProjectVersion
ThisBuild / organization     := "io.kevinlee"
ThisBuild / crossScalaVersions := CrossScalaVersions
ThisBuild / developers   := List(
      Developer("Kevin-Lee", "Kevin Lee", "kevin.code@kevinlee.io", url("https://github.com/Kevin-Lee"))
    )
ThisBuild / scmInfo :=
  Some(ScmInfo(
    url("https://github.com/Kevin-Lee/github-actions-sbt-example")
    , "https://github.com/Kevin-Lee/github-actions-sbt-example.git"
  ))
ThisBuild / homepage := Some(new URL("https://github.com/Kevin-Lee/github-actions-sbt-example"))
ThisBuild / crossVersion := CrossVersion.full

val hedgehogVersion = "d0d76f6df378614294d4c78be440a558e9bd3e85"
val hedgehogRepo = "hedgehog-repor" at "https://dl.bintray.com/hedgehogqa/scala-hedgehog"

val hedgehogLibs: Seq[ModuleID] = Seq(
  "hedgehog" %% "hedgehog-core" % hedgehogVersion % Test
  , "hedgehog" %% "hedgehog-runner" % hedgehogVersion % Test
  , "hedgehog" %% "hedgehog-sbt" % hedgehogVersion % Test
)

lazy val cats: ModuleID = "org.typelevel" %% "cats-core" % "2.0.0"
lazy val catsEffect: ModuleID = "org.typelevel" %% "cats-effect" % "2.0.0"

lazy val sbtGitHubActionsExample = (project in file("."))
  .enablePlugins(DevOopsScalaPlugin, DevOopsGitReleasePlugin, MdocPlugin, MicrositesPlugin)
  .settings(
    name := "github-actions-sbt-example"
  , description  := "GitHub Actions for sbt project"
  , addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1")
  , resolvers ++= Seq(
        Resolver.sonatypeRepo("releases")
      , hedgehogRepo
      )
  , libraryDependencies ++= hedgehogLibs ++ Seq(cats, catsEffect)
  , testFrameworks ++= Seq(TestFramework("hedgehog.sbt.Framework"))

  /* Bintray { */
  , bintrayPackageLabels := Seq("Scala", "sbt", "GitHub", "GitHub Actions")
  , bintrayVcsUrl := Some("""git@github.com:Kevin-Lee/github-actions-sbt-example.git""")
  , licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
  /* } Bintray */

  , micrositeAuthor := "Kevin Lee"
  , micrositeHomepage := "https://blog.kevinlee.io"
  , micrositeDescription := description.value
  , micrositeGithubOwner := "Kevin-Lee"
  , micrositeGithubRepo := "github-actions-sbt-example"
  , micrositeBaseUrl := "/github-actions-sbt-example"
  , micrositeDocumentationUrl := s"${micrositeBaseUrl.value}/docs"
  , micrositePushSiteWith := GitHub4s
  , micrositeGithubToken := sys.env.get("GITHUB_TOKEN")
//  , micrositeTheme := "pattern"
  , micrositeHighlightTheme := "atom-one-light"
  , micrositeGitterChannel := false
  , micrositeGithubLinks := false
  , micrositeShareOnSocial := false
  , micrositeHighlightLanguages ++= Seq("bash", "shell")

)
