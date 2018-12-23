package scalqa; package Any; package Ilk; package Z; package A

private[Ilk] object Refs extends Base[AnyRef] with Tag.ObjectLike[AnyRef] {

  @inline final override def primitiveOpt = Opt.Void

  override def isPrimitive = false

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
