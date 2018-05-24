package scalqa; package Coll; package Val

abstract class _Class[A] private[Val] extends Coll[A] with Able.Plus.Tagged[A] with Able.Minus[A] with Able.Void {
  protected type TARGET =  _Class[A]

  def allReversed: ~[A]

}

object _Class extends Able.Void.Companion.Typed[Val](Z.Void.cast)
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
