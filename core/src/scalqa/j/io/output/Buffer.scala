package scalqa; package j; package io; package output; import language.implicitConversions

import Output.Buffer
import java.io.{ ByteArrayOutputStream as REAL }

object Buffer extends AnyRef.Opaque.Base[Buffer, REAL]("Io.Output.Buffer"):
  def apply(initSize: Int = 512): Buffer = new zByteArrayOutputStream(initSize).toOpaque

  extension(inline x: Buffer)
    inline def size    : Int         = x.real.cast[zByteArrayOutputStream]._count
    inline def bytes   : Array[Byte] = x.real.toByteArray
    inline def clear   : Unit        = x.real.reset
    inline def toInput : Io.Input    = Input(x.bytes)

  object TYPE:
    opaque type DEF <: Output.TYPE.DEF = Output.TYPE.DEF & REAL


  // **************************************************************************************************************
  private class zByteArrayOutputStream(isz: Int) extends REAL(isz):
    def _count: Int = count


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

   [[J.Output.Buffer]] is an opaque value, backed by java.io.ByteArrayOutputStream

*/