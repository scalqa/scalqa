package scalqa; package j; package io; package output; import language.implicitConversions

import java.lang.{ String => S }
import Output.Text

object Text extends Any.Ref.Custom.Type[Text, java.io.OutputStreamWriter]("Io.Output.Text"):
  inline def apply(inline v: Io.Output): Text = new java.io.OutputStreamWriter(v.real).asOpaque[Text]

  extension (x: Text)
    inline def float (inline v: Float)                                          : Text = { x.real.write(S.valueOf(v)); x }
    inline def double(inline v: Double)                                         : Text = { x.real.write(S.valueOf(v)); x }
    inline def long  (inline v: Long)                                           : Text = { x.real.write(S.valueOf(v)); x }
    inline def byte  (inline v: Byte)                                           : Text = { x.real.write(S.valueOf(v)); x }
    inline def short (inline v: Short)                                          : Text = { x.real.write(S.valueOf(v)); x }
    inline def int   (inline v: Int)                                            : Text = { x.real.write(S.valueOf(v)); x }
    inline def char  (inline v: Char)                                           : Text = { x.real.write(S.valueOf(v)); x }
    inline def string(inline v: String)                                         : Text = { x.real.write(v); x }
    inline def string(inline v: String, r: Int.<>)                              : Text = { x.real.write(v, r.start, r.size); x }
    inline def string(inline v: String, inline start:Int, inline size:Int)      : Text = { x.real.write(v, start, size); x }
    inline def array( inline a: Array[Char])                                    : Text = { x.real.write(a); x }
    inline def array( inline a: Array[Char], r: Int.<>)                         : Text = { x.real.write(a, r.start, r.size); x }
    inline def array( inline a: Array[Char], inline start:Int, inline size:Int) : Text = { x.real.write(a, start, size); x }
    inline def flush                                                            : Text = { x.real.flush; x }
    inline def writeAllAndClose(inline v: String)                               : Unit = { x.real.write(v); x.close }

  object opaque:
    opaque type `type` <: java.io.Closeable & Opaque.Ref = java.io.OutputStreamWriter & Opaque.Ref
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Output.Text]] is an opaque value, backed by java.io.OutputStreamWriter

*/