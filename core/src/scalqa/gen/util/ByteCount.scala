package scalqa; package gen; package util; import language.implicitConversions

import Gen.ByteCount

object ByteCount extends Long.Custom.Data.Number[ByteCount]("ByteCount"):
  /**/     inline def apply(inline v: Long)  : ByteCount = v.asOpaque[ByteCount]
  override        def isVoid(v: ByteCount)   : Boolean   = v.real == 0L
  override        def tag(v: ByteCount)      : String    = v.toString + " ByteCount"
  implicit inline def xxRequest(inline v: \/): ByteCount = 0L.asOpaque[ByteCount]

  extension(inline x: ByteCount)
    inline def toBrief : String = x.real.toBrief + 'B'
    inline def toLongKb: Long   = x.real / 1000
    inline def toLongMb: Long   = x.real / 1_000_000
    inline def toLongGb: Long   = x.real / 1_000_000_000

  object opaque:
    opaque type `type` <: Opaque.Long = Opaque.Long

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@object opaque -> ### Byte Size

   [[ByteCount]] is an opaque Long value, used to indicate something like "File size" or "memory allocation", whatever is counted in bytes

*/
