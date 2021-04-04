import sbt.Keys._
import sbt._

object Build {

  lazy val cleanMerge = taskKey[Unit]("Prepare Merged")
  lazy val merge      = taskKey[Unit]("Prepare Merged")

  lazy val commonSettings = Seq(
    scalaVersion           := "3.0.0-RC2",
    version                := "0.99",
    organization           := "org.scalqa",
    scalaSource in Compile := baseDirectory.value / "src",
    javaSource  in Compile := baseDirectory.value / "src"
  )

  lazy val core    : Project = project.in(file("core"))                        .settings(commonSettings)
  lazy val fx      : Project = project.in(file("fx"))          .dependsOn(core).settings(commonSettings,fork in run := true)
  lazy val test    : Project = project.in(file("test"))        .dependsOn(fx)  .settings(commonSettings,fork in run := true)
  lazy val sample  : Project = project.in(file("sample"))      .dependsOn(fx)  .settings(commonSettings,fork in run := true)
  lazy val generate: Project = project.in(file("generate"))    .dependsOn(core).settings(commonSettings,fork in run := true).settings(cleanMerge:= _cleanMerge.value, merge:= _merge.value)
  lazy val doc     : Project = project.in(file("generate/doc")).dependsOn(core).settings(commonSettings,fork in run := true).settings(cleanMerge:= _cleanMerge.value, merge:= _merge.value)
  lazy val release : Project = project.in(file("generate/release"))            .settings(commonSettings)

  def  _copy       = Def.taskDyn{ ( generate / Compile / run).toTask(" "+baseDirectory.value.toString) }
  def  _merge      = Def.taskDyn{ _copy.value; ( release / Compile / compile ) }
  def  _cleanMerge = Def.taskDyn{ _copy.value; ( release / Compile / clean ).value; ( release / Compile / compile )}

}
