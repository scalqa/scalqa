package scalqa; package fx; package util; package javaFx; import language.implicitConversions

abstract class Enum[J_ENUM <: java.lang.Enum[J_ENUM]] extends scala.reflect.Enum:
  def real: J_ENUM

object Enum:

  abstract class Companion[ENUM <: Enum[J_ENUM], J_ENUM <: java.lang.Enum[J_ENUM]] extends Any.Enum.Companion[ENUM] with TwoWayFun[J_ENUM, ENUM]:
    /**/            def apply(v: J_ENUM)  : ENUM   = ><(v.ordinal)
    /**/            def undo(v: ENUM)     : J_ENUM = v.real
    implicit inline def xxJava(v: J_ENUM) : ENUM   = ><(v.ordinal)
    implicit inline def xx_Java(v: ENUM)  : J_ENUM = v.real

    inline given FxConverter: TwoWayFun[J_ENUM, ENUM] = this

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/