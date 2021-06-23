import sbt._
import sbt.Keys._

object Build {

  lazy val merge      = taskKey[Unit]("Merge")

  lazy val commonSettings = Seq(
    scalaVersion           := "3.0.0",
    version                := "0.93",
    organization           := "org.scalqa",
    scalaSource in Compile := baseDirectory.value / "src",
    javaSource  in Compile := baseDirectory.value / "src"
  )

  lazy val fxSettings = commonSettings ++ Seq({
    val osName = System.getProperty("os.name") match {
      case n if n.startsWith("Linux")   => "linux"
      case n if n.startsWith("Mac")     => "mac"
      case n if n.startsWith("Windows") => "win"
      case _                            => throw new Exception("Unknown platform!")
    }
    libraryDependencies ++= Seq("base", "controls", "graphics").map(m => "org.openjfx" % s"javafx-$m" % "11.0.2" classifier osName)
  })

  lazy val core    : Project = project.in(file("core"))                                .settings(commonSettings)
  lazy val fx      : Project = project.in(file("fx"))                  .dependsOn(core).settings(fxSettings,    fork in run := true)
  lazy val test    : Project = project.in(file("test"))                .dependsOn(fx)  .settings(commonSettings,fork in run := true)
  lazy val release : Project = project.in(file("project/release"))     .dependsOn(core).settings(commonSettings,fork in run := true).settings(merge:= _merge.value)
  lazy val docs    : Project = project.in(file("project/release/docs")).dependsOn(core).settings(fxSettings,    fork in run := true).settings(merge:= _merge.value)
  lazy val scalqa  : Project = project.in(file("project/release/scalqa"))              .settings(fxSettings)

  def  _copy   = Def.taskDyn{ ( release / Compile / run).toTask(" "+baseDirectory.value.toString) }
  def  _merge  = Def.taskDyn{ _copy.value; ( scalqa / Compile / clean ).value; ( scalqa / Compile / compile )}

}