package scalqa; package Coll; package O; package The

class Proxy[A](protected val real: O[A]) extends Proxy.Like[A]

object Proxy {

  trait Like[A] extends Coll.The.Proxy.Like[A] with O[A] {

    protected def real: O[A]

    override def onChange(f: Coll[Change[A]] => Any) = real.onChange(f)

    override def onObservableChange(f: () => Any) = real.onObservableChange(f)

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
