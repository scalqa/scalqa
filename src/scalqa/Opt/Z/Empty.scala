package scalqa; package Opt; package Z

private[Opt] class Empty private[Opt] (val value: Throwable) {

  override def toString = value.toString

}

private[Opt] object Empty {

  object Void extends Empty(new Exception("Void")) with Void { override def toString = "Void" }

  object VoidAlt extends Empty(Void.value) with Void { override def toString = "VoidAlt" }

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/