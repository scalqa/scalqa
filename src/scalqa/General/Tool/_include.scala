package scalqa; package General; package Tool

private[scalqa] trait _include {

  lazy val Assert = Tool.Assert

  val Fail = Tool.Fail

  val Pause = Tool.Pause

  lazy val Print = Tool.Print

  val Schedule = Tool.Schedule

  val Random = Tool.Random.This

  val * = Tool.VariableArguments

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @val * -> General Tool
 *
 *   Universally available General Tool [[General.Tool.VariableArguments VariableArguments]]
 *
 * @val Assert -> General Tool
 *
 *   Universally available General Tool [[General.Tool.Assert Assert]]
 *
 * @val Fail -> General Tool
 *
 *   Universally available General Tool [[General.Tool.Fail Fail]]
 *
 * @val Pause -> General Tool
 *
 *   Universally available General Tool [[General.Tool.Pause Pause]]
 *
 * @val Print -> General Tool
 *
 *   Universally available General Tool [[General.Tool.Print Print]]
 *
 * @val Schedule -> General Tool
 *
 *   Universally available General Tool [[General.Tool.Schedule Schedule]]
 *
 * @val Random -> General Tool
 *
 *   Universally available General Tool [[General.Tool.Random Random]]
 *
 */
