package scalqa; package Able; package Void; package Companion

private[Void] class Like[T](voidValue: T) {

  protected lazy val Void: T = {
    if (voidValue == null) Fail("null passed")
    if (voidValue.isVoid.not) Fail("nonVoid object passed as void for " + getClass)
    voidValue
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
