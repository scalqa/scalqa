package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[scalqa] class Convert_View[A,B](protected val real: Idx[A], map: A => B) extends idx.X.Abstract[B]:
  def apply(i: Int) = map(real(i))
  def size          = real.size

private[scalqa] object Convert_View:

  class O[A,B](protected override val real: Idx.Observable[A], map: A => B) extends Convert_View[A,B](real, map) with Idx.Observable[B]:
    def onChange[U](l: Pack[Idx.O.Event[B]] => U): Event.Control = real.onChange(Event.Id.map1(l,v => l(v.stream.map(_.convert(map)).pack)))

  object O:
    class Stateful[A,B](protected val trgt: Idx.Observable[A], private[z] val pm: A => B) extends J.Util.Proxy.Idx.O[B]:
      protected val real = new Idx.OM.X.Basic[B] {
        this ++= trgt.stream.map(pm)
        val hardRef: Any = trgt.onChange(c => this.modify(l => c.stream.foreach {
          case v: Idx.Event.Add[A]        => l.addAllAt(v.range.start, v.items.stream.map(pm))
          case v: Idx.Event.Remove[A]     => l.removeRange(v.range)
          case v: Idx.Event.Update[A]     => if (v.isRefresh) this.fireChange(Pack(Idx.Event.Update.refresh(v.range, real.rangeView(v.range)))) else l.updateAllAt(v.range.start, v.items.stream.map(pm))
          case v: Idx.Event.Reposition[A] => l.reposition(v.permutation)
        })).removeHardReference
      }

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
