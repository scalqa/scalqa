package scalqa; package Any; package Ilk; package Z

private[scalqa] object Shift {

  val Prim = 1
  val Ref = 3

  val PrimPrim = shift(Prim, Prim)
  val PrimRef = shift(Prim, Ref)
  val RefPrim = shift(Ref, Prim)
  val RefRef = shift(Ref, Ref)

  def id(v: Like): Int = if (v.isPrimitive) Prim else Ref

  @inline final def shift(x: Int, y: Int): Int = x << y

  @inline final def shift(x: Like, y: Like): Int = x.shiftId << y.shiftId
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
