package scalqa; package `val`; package idx; package z; import language.implicitConversions

object TwoWay_View:

  class M[A,B](protected val real: Idx.Mutable[A], f: TwoWayFunction[A,B]) extends Idx.Mutable.X.Abstract[B]:
    def apply(i: Int)            : B    = f(real(i))
    def size                     : Int  = real.size
    def addAt(i: Int, e: B)      : Unit = real.addAt(i, f.undo(e))
    def updateAt(r: Int, e: B)   : Unit = real.update(r, f.undo(e))
    def removeRange(r: Int.Range): Unit = real.removeRange(r)

  class OM[A,B](protected override val real: Idx.ObservableMutable[A], f: TwoWayFunction[A,B]) extends M[A,B](real, f) with Idx.ObservableMutable[B]:
    def refreshRange(r: Int.Range)                    : Unit          = real.refreshRange(r)
    def modify(ch: Idx.Mutable[B] => Unit)            : Unit          = real.modify(l => ch(l.mutableMapView(using f)))
    def onChange[U](l: Pack[Observable.Event[B]] => U): Event.Control = real.onChange(Event.Id.map1(l, v => l(v.stream.map(_.convert(f)).pack)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
