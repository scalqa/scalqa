package scalqa; package j; package io; import output.*; import language.implicitConversions

import Io.Output
import java.io.{ OutputStream as REAL }

object Output extends AnyRef.Opaque.Base[Output, REAL]("Io.Output"):
  inline def apply(inline v: REAL): Output = v.toOpaque
  /**/   def apply(f: File.Path)  : Output = apply(java.io.FileOutputStream(f.real.toFile))

  extension (x: Output)
    def asBytes   : Output.Bytes          = Bytes(x)
    def asText    : Text                  = Text(x)
    def asData    : Data                  = Data(x)
    def asPrinter : java.io.PrintStream   = java.io.PrintStream(x.real)
    def flush     : Output                = { x.real.flush; x }

  object TYPE:
    opaque type DEF <: java.io.Closeable & AnyRef.Opaque = REAL & AnyRef.Opaque

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Bytes  = output.Bytes.TYPE.DEF;  transparent inline def Bytes  = output.Bytes
  type Data   = output.Data.TYPE.DEF;   transparent inline def Data   = output.Data
  type Text   = output.Text.TYPE.DEF;   transparent inline def Text   = output.Text
  type Buffer = output.Buffer.TYPE.DEF; transparent inline def Buffer = output.Buffer

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

   [[J.Output]] is an opaque value, backed by java.io.OutputStream

*/