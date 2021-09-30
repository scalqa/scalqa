package scalqa; package gen; package util; import language.implicitConversions

import Util.ByteCount

object ByteCount extends Long.Opaque.Data.Numerical[ByteCount]("ByteCount"):
  /**/     inline def apply(inline v: Long)     : ByteCount = v.toOpaque
  override        def value_isVoid(v: ByteCount): Boolean   = v.real == 0L
  override        def value_tag(v: ByteCount)   : String    = v.real.toString + ".ByteCount"
  implicit inline def implicitRequest(v: \/)    : ByteCount = 0L.toOpaque

  extension(inline x: ByteCount)
    inline def tagBrief: String = x.real.tagBrief + 'B'

  object TYPE:
    opaque type DEF <: Long.Opaque = Long.Opaque & Long

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**

@type DEF  -> ### Byte Size

   [[ByteCount]] is an opaque Long value, used to indicate something like "File size" or "memory allocation", whatever is counted in bytes

*/
