package scalqa; package Util; package Void; package Setup

private[Void] class Like[T](voidValue: T) {

  protected lazy val Void: T = {
    if (voidValue == null) App.Fail("null passed")
    if (voidValue.isVoid.!) App.Fail("nonVoid object passed as void for " + getClass + ": " + voidValue)
    voidValue
  }
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
