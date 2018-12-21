

lazy val commonSettings = Seq(
  scalaVersion := "2.12.4",
  version := "0.23"
)

lazy val core = project
  .settings(
     commonSettings,
     name := "scalqa-core"
  )

lazy val fx = project
  .dependsOn(core) 
  .settings(
     commonSettings,
     name := "scalqa-fx"
  )
