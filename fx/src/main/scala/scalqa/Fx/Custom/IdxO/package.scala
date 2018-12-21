package scalqa; package Fx; package Custom

package object IdxO {

  def changes[A](v: javafx.collections.ListChangeListener.Change[_ <: A]): Idx[Idx.Change[A]] = Idx.O.Change.Builder.make[A](Idx.wrap(v.getList)).I(b => {

    val trgt = v.asInstanceOf[javafx.collections.ListChangeListener.Change[A]]

    def range: Idx.Range = trgt.getFrom <>> trgt.getTo

    def reposition: Idx.Range.Reposition = { val r = range; Idx.Reposition.make(r, r.all.map(trgt.getPermutation).toRaw[Ints]) }

    trgt.reset
    while (trgt.next) {
      if (trgt.wasPermutated) b.reposition(reposition)
      else if (trgt.wasUpdated) b.update(range)
      else {
        if (trgt.wasRemoved) b.removeAt(trgt.getFrom, Idx.wrap(trgt.getRemoved))
        if (trgt.wasAdded) b.addAt(range)
      }
    }
    b.seal
  })
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
