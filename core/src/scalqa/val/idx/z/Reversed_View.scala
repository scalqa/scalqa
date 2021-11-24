package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[scalqa] class Reversed_View[A](protected val real: Idx[A]) extends Idx[A]:
  def apply(i: Int) = real(size - i - 1)
  def size          = real.size

private[scalqa] object Reversed_View:

  class O[A](protected override val real: Idx.Observable[A]) extends Reversed_View(real) with Idx.Observable.X.Base[A]:
    val hardRef = real.onChange(ci => fireChange(ci.stream.map(c => {
      val in = (real.size - c.range.endX) <>= c.range.size
      c match {
        case v: Idx.Event.Add[A]                   => Idx.Event.Add(in, v.items.reversedView)
        case v: Idx.Event.Remove[A]                => Idx.Event.Remove(in, v.items.reversedView)
        case v: Idx.Event.Update[A] if v.isRefresh => Idx.Event.Update.refresh(in, v.items.reversedView)
        case v: Idx.Event.Update[A]                => Idx.Event.Update(in, v.items.reversedView, v.oldItems.reversedView)
        case v: Idx.Event.Reposition[A]            => J.unsupportedOperation()
        case _                                     => J.illegalState()
      } : Observable.Event[A]
    }).pack)).removeHardReference


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
