package scalqa; package Numeric

private[Numeric] trait __ extends Any {
  protected type THIS
  protected type VALUE

  protected def This: THIS
  protected def value: VALUE
  protected def math: Math[VALUE]
  protected def map: BiMap[VALUE, THIS]
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
