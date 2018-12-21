package scalqa; package Idx; package O; package Z

private[O] object transform {

  def apply[A](c: Change[A], rangeFun: Idx.Range => Idx.Range, itemsFun: Idx[A] => Idx[A], repositionIndexesFun: Ints => Ints = i => i): Change[A] =
    c match {
      case v: Add[A] =>
        val r = v.range
        val nr = rangeFun(r)
        val l = v.items
        val nl = itemsFun(l)
        if (r == nr && l == nl) v else Add.make(nr, nl)
      case v: Remove[A] =>
        val r = v.range
        val nr = rangeFun(r)
        val l = v.items
        val nl = itemsFun(l)
        if (r == nr && l == nl) v else Remove.make(nr, nl)
      case v: Refresh[A] =>
        val r = v.range
        val nr = rangeFun(r)
        if (r == nr) v else Refresh.make(nr)
      case v: Reposition[A] =>
        val r = v.range
        val nr = rangeFun(r)
        val i = v.indexes
        val ni = repositionIndexesFun(i)
        if (r == nr && i == ni) v else Change.Reposition.make(nr, ni)
      case v => App.Fail()
    }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
