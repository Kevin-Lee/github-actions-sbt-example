logLevel := sbt.Level.Warn

addSbtPlugin("org.foundweekends" % "sbt-bintray" % "0.5.5")

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.0")

addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.2.7")

addSbtPlugin("io.kevinlee" % "sbt-devoops" % "1.0.3")

addSbtPlugin("org.scalameta" % "sbt-mdoc" % "2.1.1" cross CrossVersion.full)

addSbtPlugin("com.47deg" % "sbt-microsites" % "1.0.2")
