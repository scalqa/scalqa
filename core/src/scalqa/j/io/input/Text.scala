package scalqa; package j; package io; package input; import language.implicitConversions

import Input.Text

object Text extends Any.Ref.Custom.Type[Text, java.io.Reader]("Io.Input.Text"):
  inline def apply(inline v: Io.Input): Text = new java.io.InputStreamReader(v.real).asOpaque[Text]

  extension(inline x: Text)
    inline def read                                    : Int                         = x.real.read
    inline def read(inline ca: Array[Char])            : Int                         = x.real.read(ca)
    inline def read(inline ca: Array[Char], i: Int.<>) : Int                         = x.real.read(ca, i.start, i.size)
    inline def readAll                                 : String                      = x.read(MAX)
    inline def readAllAndClose                         : String                      = { val v = x.readAll; x.close; v }
    inline def separated_~(separator: Char => Boolean) : ~[Char.Idx & CharSequence]  = new z.SeparatedTextStream(x, separator)
    inline def ~                                       : Char.~                      = new Z.CharStream(x.real)

  extension (x: Text) def read(size: Int): String = {
    val r: java.io.Reader = x.real
    var sz = 0
    val sw = new java.io.StringWriter
    val ca = new Array[Char](256)
    def load = if (size - sz >= ca.length) r.read(ca) else r.read(ca, 0, size - sz)
    var i = load
    while (i > -1 && sz <= size)
      sz += i;
      sw.write(ca, 0, i);
      i = load
    sw.getBuffer.toString
  }

  object opaque:
    opaque type `type` <: java.io.Closeable & Opaque.Ref = java.io.Reader & Opaque.Ref
/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Input.Data]] is an opaque value, backed by java.io.Reader

*/
