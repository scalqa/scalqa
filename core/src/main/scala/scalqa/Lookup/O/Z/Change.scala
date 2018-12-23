package scalqa; package Lookup; package O; package Z

private[O] trait Change[A, B] extends Any.Collection.O.Change[B] {

  def pairs: Any.Collection[(A, B)]

  def items: Any.Collection[B] = pairs.asMappedView(_._2)

  override def toInfo = super.toInfo += (("pairs", pairs.all.format(",")))

}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
