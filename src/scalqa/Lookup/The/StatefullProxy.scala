package scalqa; package Lookup; package The

class StatefullProxy[A, B, C](base: Lookup[A, C], f: C => B)(implicit odr: Sorting[A]) extends The[A, B]((a: A) => base.opt(a).map(f)) {

  override def size = base.size

  override def allPairs: ~[(A, B)] = {
    if (real.size != base.size) this.synchronized { base.allPairs.sortBy(_._1)(odr).dropAllBy(_._1, real.allPairs.map(_._1)).map(_.map2(f)).apply(real += _) }
    super.allPairs
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
