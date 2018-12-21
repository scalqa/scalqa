package scalqa; package Custom; package Proxy; package Idx

class O[A](protected val real: scalqa.Idx.O[A]) extends O.Like[A]

object O {

  trait Like[A] extends Custom.Proxy.Idx.Like[A] with scalqa.Idx.O[A] with Any.Wrap[scalqa.Idx.O[A]] {

    override def onChange(f: scalqa.Idx[scalqa.Idx.O.Change[A]] => Any) = real.onChange(f)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
