package scalqa; package Index; package O; package Change; package Z

private[O] object transform {

  def apply[A](c: Change[A], rangeFun: Int.Range => Int.Range, itemsFun: Index[A] => Index[A], repositionIndexesFun: Ints => Ints = i => i): Change[A] =
    c match {
      case v: O.Add[A] =>
        val r = v.range
        val nr = rangeFun(r)
        val l = v.items
        val nl = itemsFun(l)
        if (r == nr && l == nl) v else O.Add.get(nr, nl)
      case v: O.Remove[A] =>
        val r = v.range
        val nr = rangeFun(r)
        val l = v.items
        val nl = itemsFun(l)
        if (r == nr && l == nl) v else Index.O.Remove.get(nr, nl)
      case v: O.Refresh[A] =>
        val r = v.range
        val nr = rangeFun(r)
        if (r == nr) v else O.Refresh.get(nr)
      case v: O.Reposition[A] =>
        val r = v.range
        val nr = rangeFun(r)
        val i = v.indexes
        val ni = repositionIndexesFun(i)
        if (r == nr && i == ni) v else O.Reposition.get(nr, ni)
      case v => Fail()
    }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/