package scalqa; package Idx; package O; package Z; package A

private[scalqa] class ReversedView[A] private (n: Unit, protected override val real: Idx.O[A]) extends Idx.Z.A.ReversedView(real) with Idx.O.A.Base[A] with Any.Ref.Extra {
  def this(l: Idx.O[A]) {
    this((), l)

    _onStartListening(real.onChange(c => fireChange {
      O.transformIdx(
        c,
        r => (real.size - r.start - 1) <>>+ r.size,
        (l: Idx[A]) => l.asReversedView,
        _.all.reverse.toPrimitive[Ints])
    }).cancelIf(() => !_hasListeners))
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
