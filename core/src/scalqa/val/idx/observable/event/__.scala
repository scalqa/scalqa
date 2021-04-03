package scalqa; package `val`; package idx; package observable; import language.implicitConversions

abstract class Event[A] private[observable](final val name: String) extends Able.Info:
  /**/               def range                : Int.<>
  /**/               def convert[B](f: A => B): Event[B]
  @tn("project_Opt") def project_?(i: Int.<>) : Opt[Event[A]]
  override           def info                 : Info              = Info("IdxChange") += ("type", name) += ("range", range.tag)

object Event:

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Add[A]        = event.Add[A];        inline def Add        = event.Add
  type Remove[A]     = event.Remove[A];     inline def Remove     = event.Remove
  type Update[A]     = event.Update[A];     inline def Update     = event.Update
  type Reposition[A] = event.Reposition[A]; inline def Reposition = event.Reposition
  type Recorder[A]   = event.Recorder[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@def range -> Affected range

       Range of items affected


*/
