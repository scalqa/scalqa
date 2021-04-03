package scalqa; package j; package io; package input; import language.implicitConversions

import Input.Bytes

object Bytes extends Any.Ref.Custom.Type[Bytes, java.io.InputStream]("Io.Input.Bytes"):
  inline def apply(inline v: Io.Input): Bytes = v.real.asOpaque[Bytes]

  extension(inline x: Bytes)
    /**/            inline def read                                                        : Int         = x.real.read
    /**/            inline def read(inline ba: Array[Byte])                                : Int         = x.real.read(ba)
    /**/            inline def read(inline ba: Array[Byte], inline from:Int,inline sz:Int) : Int         = x.real.read(ba, from, sz)
    @tn("read_Opt") inline def read_?                                                      : Byte.Opt    = { val i = x.read; if (i < 0) \/ else (i - Byte.min).Byte }
    /**/            inline def readAll                                                     : Array[Byte] = toByteArray(x)
    /**/            inline def readAllAndClose                                             : Array[Byte] = x.readAll.^(_ => x.close)

  object opaque:
    opaque type `type` <: java.io.Closeable & Opaque.Ref = java.io.InputStream & Opaque.Ref
// -------------------------------------------------------------------------------------------------------------------------------
  private def toByteArray(in: Bytes): Array[Byte] =
    var a, buf = new Array[Byte](1000)
    var len = 0
    var i = in.read(buf)
    while (i != -1)
      while (a.length <= len) a = a.copySize(len*2)
      buf.copyTo(a, len, 0, i)
      len += i
      i = in.read(buf)
    a.copySize(len)


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Input.Bytes]] is an opaque value, backed by java.io.InputStream

@def read -> Byte

       Reads the next short from input as Int in range 0 <>> 256

       Returns -1 if no more data


@def read_? -> Byte option

       Optionally returns next short from input

       If no more data, \/ is returned


@def read ->  To array

      Reads input byte to given [[Array]]

      @param range Array range to use. By default the full array is used

      @return  the total number of byte read into the array, or -1 if there is no more data


*/
