package scalqa; package j; package io; package output; import language.implicitConversions

import Output.Bytes
import java.io.{ OutputStream as REAL }

object Bytes extends AnyRef.Opaque.Base[Bytes, REAL]("Io.Output.Bytes"):
  inline def apply(inline v: Io.Output): Bytes = v.real.toOpaque

  extension(inline x: Bytes)
    inline def writeByte(inline b: Int)                                       : Unit  = x.real.write(b)
    inline def write(inline ba: Array[Byte])                                  : Unit  = x.real.write(ba)
    inline def write(inline ba: Array[Byte],inline start:Int,inline size:Int) : Unit  = x.real.write(ba, start, size)
    inline def writeAndClose(in: Io.Input)                                    : Unit  = { x.write(in); x.close }
    inline def flush                                                          : Bytes = { x.real.flush; x }
  extension(x: Bytes)
    /**/   def write(input: Io.Input)                                         : Unit  = { val in = input.asBytes
    /**/                                                                                  val a  = new Array[Byte](1000)
    /**/                                                                                  var i  = in.read(a)
    /**/                                                                                  while (i >= 0)
    /**/                                                                                    x.write(a, 0, i)
    /**/                                                                                    i = in.read(a)
    /**/                                                                                  in.close
    /**/                                                                                 }

  object TYPE:
    opaque type DEF <: java.io.Closeable & AnyRef.Opaque = REAL & AnyRef.Opaque
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

   [[J.Output.Bytes]] is an opaque value, backed by java.io.OutputStream

*/