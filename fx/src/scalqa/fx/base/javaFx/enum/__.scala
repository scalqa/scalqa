package scalqa; package fx; package base; package javaFx; import language.implicitConversions

abstract class Enum[J_ENUM <: java.lang.Enum[J_ENUM]] extends scala.reflect.Enum:
  def real: J_ENUM

object Enum:

  abstract class Companion[ENUM <: Enum[J_ENUM], J_ENUM <: java.lang.Enum[J_ENUM]] extends  EnumCompanion[ENUM] with TwoWayFunction[J_ENUM, ENUM]:
    /**/            def apply(v: J_ENUM)           : ENUM   = apply(v.ordinal)
    /**/            def undo(v: ENUM)              : J_ENUM = v.real
    implicit inline def implicitFromJava(v: J_ENUM): ENUM   = apply(v.ordinal)
    implicit inline def implicitToJava(v: ENUM)    : J_ENUM = v.real

    inline given FxConverter: TwoWayFunction[J_ENUM, ENUM] = this

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/