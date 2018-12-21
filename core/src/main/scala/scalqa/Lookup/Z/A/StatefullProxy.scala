package scalqa; package Lookup; package Z; package A

private[scalqa] class StatefullProxy[A, B, C](base: Lookup[A, C], f: C => B)(implicit odr: Ordering[A]) extends Basic[A, B]((a: A) => base.getOpt(a).map(f)) {

  override def size = base.size

  override def allPairs: ~[(A, B)] = {
    if (real.size != base.size) this.synchronized { base.allPairs.sortBy(_._1)(odr).dropAllBy(_._1, real.allPairs.map(_._1)).map(_.map2(f)).foreach(real += _) }
    super.allPairs
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
