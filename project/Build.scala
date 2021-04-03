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

  lazy val coreProject   : Project = project.in(file("core"))                            .settings(commonSettings)
  lazy val fxProject     : Project = project.in(file("fx"))       .dependsOn(coreProject).settings(commonSettings,fork in run := true)
  lazy val testProject   : Project = project.in(file("test"))     .dependsOn(fxProject)  .settings(commonSettings,fork in run := true)
  lazy val sampleProject : Project = project.in(file("sample"))   .dependsOn(fxProject)  .settings(commonSettings,fork in run := true)
  lazy val mergeProject  : Project = project.in(file("merge"))    .dependsOn(coreProject).settings(commonSettings,fork in run := true).settings(cleanMerge:= _cleanMerge.value, merge:= _merge.value)
  lazy val docProject    : Project = project.in(file("merge/doc")).dependsOn(coreProject).settings(commonSettings,fork in run := true).settings(cleanMerge:= _cleanMerge.value, merge:= _merge.value)
  lazy val releaseProject: Project = project.in(file("merge/release"))                   .settings(commonSettings)

  def  _copy       = Def.taskDyn{ ( mergeProject / Compile / run).toTask(" "+baseDirectory.value.toString) }
  def  _merge      = Def.taskDyn{ _copy.value; ( releaseProject / Compile / compile ) }
  def  _cleanMerge = Def.taskDyn{ _copy.value; ( releaseProject / Compile / clean ).value; ( releaseProject / Compile / compile )}

}
