package scalqa; package `val`; package idx; package observable; package event; import language.implicitConversions

object Z:
  class Add[A]( val range: Int.Range, val items: Idx[A])                          extends Event.Add[A]
  class Remove[A]( val range: Int.Range, val items: Idx[A])                       extends Event.Remove[A]
  class Update[A]( val range: Int.Range, val items: Idx[A], val oldItems: Idx[A]) extends Event.Update[A] { def isRefresh = items == oldItems }
  class Reposition[A](val permutation: Idx.Permutation)                           extends Event.Reposition[A]

  trait Single[A] extends Event[A] with Idx[A]:
    def index         : Int
    def item          : A
    def range      : Int.Range     = index <> index
    def size          : Int       = 1
    def apply(i: Int) : A         = item
    def items         : Idx[A]    = this

  object Single:
    class Remove[A](val index: Int, val item: A)             extends Event.Remove[A] with Single[A]
    class Add   [A](val index: Int, val item: A)             extends Event.Add[A]    with Single[A]
    class Update[A](val index: Int, val item: A, oldItem: A) extends Event.Update[A] with Single[A] { def oldItems = Pack(oldItem); def isRefresh = item == oldItem }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
