import sbt._

object Deps {
  val hedgehogVersion = "d0d76f6df378614294d4c78be440a558e9bd3e85"
  val hedgehogRepo = "hedgehog-repor" at "https://dl.bintray.com/hedgehogqa/scala-hedgehog"

  val hedgehogLibs: Seq[ModuleID] = Seq(
      "hedgehog" %% "hedgehog-core" % hedgehogVersion % Test
    , "hedgehog" %% "hedgehog-runner" % hedgehogVersion % Test
    , "hedgehog" %% "hedgehog-sbt" % hedgehogVersion % Test
  )

}
