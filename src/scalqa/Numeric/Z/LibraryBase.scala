package scalqa; package Numeric; package Z

private[scalqa] trait LibraryBase[A] extends Any with _operator._extended with _use {
  protected type THIS = A
  protected type VALUE = A

  @inline protected def value = This
  @inline protected def map: BiMap[VALUE, THIS] = BiMap.getCast
  
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
