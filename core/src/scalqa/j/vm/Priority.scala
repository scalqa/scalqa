package scalqa; package j; package vm; import language.implicitConversions

import Vm.Priority

object Priority extends Int.Custom.Type[Priority]("Vm.Priority"):
  def apply(v: Int) : Priority = { assert(v in (1 <> 10), "Value " + v + " not in 1 <> 10");  v.asOpaque[Priority] }

  implicit inline def xxInt(v: Int)         : Priority = apply(v)
  implicit inline def xxRequest(v: MIN)     : Priority = 1.asOpaque[Priority]
  implicit inline def xxRequest(v: MAX)     : Priority = 10.asOpaque[Priority]
  implicit inline def xxRequest(v: DEFAULT) : Priority = 5.asOpaque[Priority]

  object opaque:
    opaque type `type` <: Opaque.Int = Opaque.Int

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[Priority]] is an opaque Int value, ranging from 1 to 10

*/