package scalqa; package j; package vm; import language.implicitConversions

import Vm.Priority

object Priority extends Int.Opaque.Base[Priority]("Vm.Priority"):
  def apply(v: Int): Priority = { assert(v in (1 <> 10), "Value " + v + " not in 1 <> 10");  v.opaque }

  implicit inline def implicitRequest(v: MIN)     : Priority = 1.opaque
  implicit inline def implicitRequest(v: MAX)     : Priority = 10.opaque
  implicit inline def implicitRequest(v: DEFAULT) : Priority = 5.opaque

  extension(inline x: Priority)
    inline def isMin: Boolean = x.real == 1
    inline def isMax: Boolean = x.real == 10

  object OPAQUE:
    opaque type TYPE <: Int.Opaque = Int.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ###

   [[Priority]] is an opaque Int value, ranging from 1 to 10.

*/