package scalqa; package j; package io; package input; import language.implicitConversions

import Input.Text
import java.io.{ Reader as REAL }

object Text extends AnyRef.Opaque.Base[Text, REAL]("Io.Input.Text"):
  inline def apply(inline v: Io.Input): Text = new java.io.InputStreamReader(v.real).toOpaque

  extension(inline x: Text)
    inline def read                                      : Int                             = x.real.read
    inline def read(size: Int)                           : String                          = Z.readString(x,size)
    inline def read(inline ca: Array[Char])              : Int                             = x.real.read(ca)
    inline def read(inline ca: Array[Char], i: Int.Range): Int                             = x.real.read(ca, i.start, i.size)
    inline def readAll                                   : String                          = read(MAX)
    inline def readAllAndClose                           : String                          = { val v = x.readAll; x.close; v }
    inline def separatedStream(separator: Char => Boolean)   : Stream[Char.Idx & CharSequence] = new z.SeparatedTextStream(x, separator)
    inline def stream                                         : Char.Stream                     = new Z.CharStream(x.real)

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

   [[J.Input.Data]] is an opaque value, backed by java.io.Reader

*/
