package scalqa; package `val`; package idx; package z; import language.implicitConversions

object TwoWay_View:

  class M[A,B](protected val real: Idx.Mutable[A], f: ReversibleFunction[A,B]) extends Idx.Mutable.X.Abstract[B]:
    /**/                def apply(i: Int)          : B    = f(real(i))
    /**/                def size                   : Int  = real.size
    /**/                def addAt(i: Int, e: B)    : Unit = real.addAt(i, f.undo(e))
    /**/                def updateAt(r: Int, e: B) : Unit = real.update(r, f.undo(e))
    @tn("remove_Range") def remove_<>(r: Int.<>)   : Unit = real.remove_<>(r)

  class OM[A,B](protected override val real: Idx.ObservableMutable[A], f: ReversibleFunction[A,B]) extends M[A,B](real, f) with Idx.ObservableMutable[B]:
    @tn("refresh_Range")def refresh_<>(r: Int.<>)                       : Unit          = real.refresh_<>(r)
    /**/                def modify(ch: Idx.Mutable[B] => Unit)          : Unit          = real.modify(l => ch(l.mutableMap_^(using f)))
    /**/                def onChange[U](l: ><[Observable.Event[B]] => U): Event.Control = real.onChange(Event.Id.map1(l, v => l(v.~.map(_.convert(f)).><)))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
