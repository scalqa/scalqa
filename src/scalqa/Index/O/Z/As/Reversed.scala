package scalqa; package Index; package O; package Z; package As

private[scalqa] class Reversed[A] private (n: Unit, protected override val real: Index.O[A]) extends Index.Z.As.Reversed(real) with Index.O.The.Base[A] with Any.Extra {
  def this(l: Index.O[A]) {
    this((), l)
    onStartListening(real.onChange(c =>
      fireChange(O.Change.transformColl(c, r => (real.size - r.start - 1) <>>+ r.size, _.asReversed, _.all.reverse.as[Array]))).cancelIf(() => !hasIndexeners))
  }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
