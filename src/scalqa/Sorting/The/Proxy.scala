package scalqa; package Sorting; package The

class Proxy[A](val real: Sorting[A]) extends Proxy.Base[A]

object Proxy {

  trait Base[A] extends Sorting[A] {

    protected def real: Sorting[A]

    protected override def position(x: A, y: A): Position = real.position(x, y)

    protected override def voidPosition = real.voidPosition

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
