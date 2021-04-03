package scalqa; package j; package io; package output; import language.implicitConversions

import Output.Buffer

object Buffer extends Any.Ref.Custom.Type[Buffer, java.io.ByteArrayOutputStream]("Io.Output.Buffer"):
  def apply(initSize: Int = 512): Buffer = new zByteArrayOutputStream(initSize).asOpaque[Buffer]

  extension(inline x: Buffer)
    inline def size    : Int         = x.real.cast[zByteArrayOutputStream]._count
    inline def bytes   : Array[Byte] = x.real.toByteArray
    inline def clear   : Unit        = x.real.reset
    inline def toInput : Io.Input    = Input(x.bytes)

  object opaque:
    opaque type `type` <: Output.opaque.`type` = Output.opaque.`type` & java.io.ByteArrayOutputStream


  // **************************************************************************************************************
  private class zByteArrayOutputStream(isz: Int) extends java.io.ByteArrayOutputStream(isz):
    def _count: Int = count


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Output.Buffer]] is an opaque value, backed by java.io.ByteArrayOutputStream

*/