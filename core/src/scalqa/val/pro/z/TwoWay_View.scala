package scalqa; package `val`; package pro; package z

private[pro] object TwoWay_View:

  class M[A,B](protected override val real: Mutable[A], bm: TwoWayFun[A,B]) extends Convert_View[A,B](real, bm) with Mutable[B]:
    def update(v: B) = real.update(bm.undo(v))

  class ObservableMutable[A,B]( protected override val real: Pro.ObservableMutable[A], bm: TwoWayFun[A,B]) extends Convert_View.O[A,B](real, bm) with Pro.ObservableMutable[B]:
    def update(v: B) = real.update(bm.undo(v))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
