package scalqa; package `val`; package idx; package observable; import language.implicitConversions

abstract class Event[A] private[observable](final val name: String) extends Able.Doc:
  def range                   : Int.Range
  def convert[B](f: A => B)   : Event[B]
  def projectOpt(i: Int.Range): Opt[Event[A]]
  override def doc            : Doc            = Doc("Idx.Event") += ("type", name) += ("range", range.tag)

object Event:

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Add[A]        = event.Add[A];        transparent inline def Add        = event.Add
  type Remove[A]     = event.Remove[A];     transparent inline def Remove     = event.Remove
  type Update[A]     = event.Update[A];     transparent inline def Update     = event.Update
  type Reposition[A] = event.Reposition[A]; transparent inline def Reposition = event.Reposition
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
