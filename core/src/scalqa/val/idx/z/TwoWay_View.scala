package scalqa; package `val`; package idx; package z; import language.implicitConversions

object TwoWay_View:

  class M[A,B](protected val real: Idx.Mutable[A], bm: TwoWayFun[A,B]) extends Idx.Mutable.X.Abstract[B]:
    /**/                def apply(i: Int)          : B    = bm(real(i))
    /**/                def size                   : Int  = real.size
    /**/                def addAt(i: Int, e: B)    : Unit = real.addAt(i, bm.undo(e))
    /**/                def updateAt(r: Int, e: B) : Unit = real.update(r, bm.undo(e))
    @tn("remove_Range") def remove_<>(r: Int.<>)   : Unit = real.remove_<>(r)

  class OM[A,B](protected override val real: Idx.ObservableMutable[A], bm: TwoWayFun[A,B]) extends M[A,B](real, bm) with Idx.ObservableMutable[B]:
    @tn("refresh_Range")def refresh_<>(r: Int.<>)                       : Unit          = real.refresh_<>(r)
    /**/                def modify(ch: Idx.Mutable[B] => Unit)          : Unit          = real.modify(l => ch(l.twoWay_^(using bm)))
    /**/                def onChange[U](l: ><[Observable.Event[B]] => U): Event.Control = real.onChange(Event.Id.map1(l, v => l(v.~.map(_.convert(bm)).><)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
