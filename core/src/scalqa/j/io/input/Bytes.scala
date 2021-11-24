package scalqa; package j; package io; package input; import language.implicitConversions

import Input.Bytes
import java.io.{ InputStream as REAL }

object Bytes extends AnyRef.Opaque.Base[Bytes, REAL]("Io.Input.Bytes"):
  inline def apply(inline v: Io.Input): Bytes = v.real.toOpaque

  extension(inline x: Bytes)
    inline def read                                                        : Int         = x.real.read
    inline def read(inline ba: Array[Byte])                                : Int         = x.real.read(ba)
    inline def read(inline ba: Array[Byte], inline from:Int,inline sz:Int) : Int         = x.real.read(ba, from, sz)
    inline def readOpt                                                     : Byte.Opt    = { val i = x.read; if (i < 0) \/ else (i - Byte.min).toByte }
    inline def readAll                                                     : Array[Byte] = Z.toByteArray(x)
    inline def readAllAndClose                                             : Array[Byte] = x.readAll.self(_ => x.close)

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

   [[J.Input.Bytes]] is an opaque value, backed by java.io.InputStream

@def read -> Byte

       Reads the next short from input as Int in range 0 <>> 256

       Returns -1 if no more data


@def readOpt -> Byte option

       Optionally returns next short from input

       If no more data, \/ is returned


@def read ->  To array

      Reads input byte to given [[Array]]

      @param range Array range to use. By default the full array is used

      @return  the total number of byte read into the array, or -1 if there is no more data


*/
