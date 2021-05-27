import sbt.Keys._
import sbt._

object Build {

  lazy val merge      = taskKey[Unit]("Merged")

  lazy val commonSettings = Seq(
    scalaVersion           := "3.0.0",
    version                := "0.92",
    organization           := "org.scalqa",
    scalaSource in Compile := baseDirectory.value / "src",
    javaSource  in Compile := baseDirectory.value / "src"
  )

  lazy val core    : Project = project.in(file("core"))                         .settings(commonSettings)
  lazy val fx      : Project = project.in(file("fx"))           .dependsOn(core).settings(commonSettings,fork in run := true)
  lazy val test    : Project = project.in(file("test"))         .dependsOn(fx)  .settings(commonSettings,fork in run := true)
  lazy val sample  : Project = project.in(file("sample"))       .dependsOn(fx)  .settings(commonSettings,fork in run := true)
  lazy val generate: Project = project.in(file("generate"))     .dependsOn(core).settings(commonSettings,fork in run := true).settings(merge:= _merge.value)
  lazy val docs    : Project = project.in(file("generate/docs")).dependsOn(core).settings(commonSettings,fork in run := true).settings(merge:= _merge.value)
  lazy val scalqa  : Project = project.in(file("generate/scalqa"))              .settings(commonSettings)

  def  _copy   = Def.taskDyn{ ( generate / Compile / run).toTask(" "+baseDirectory.value.toString) }
  def  _merge  = Def.taskDyn{ _copy.value; ( scalqa / Compile / clean ).value; ( scalqa / Compile / compile )}

}