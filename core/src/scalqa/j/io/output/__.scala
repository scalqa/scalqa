package scalqa; package j; package io; import output.*; import language.implicitConversions

import Io.Output
import java.io.{ OutputStream as REAL }

object Output extends AnyRef.Opaque.Base[Output, REAL]("Io.Output"):
  inline def apply(inline v: REAL): Output = v.opaque
  /**/   def apply(f: File.Path)  : Output = apply(java.io.FileOutputStream(f.real.toFile))

  extension (x: Output)
    def asBytes   : Output.Bytes          = Bytes(x)
    def asText    : Text                  = Text(x)
    def asData    : Data                  = Data(x)
    def asPrinter : java.io.PrintStream   = java.io.PrintStream(x.real)
    def flush     : Output                = { x.real.flush; x }

  object OPAQUE:
    opaque type TYPE <: java.io.Closeable & AnyRef.Opaque = REAL & AnyRef.Opaque

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Bytes  = output.Bytes.OPAQUE.TYPE;  transparent inline def Bytes  = output.Bytes
  type Data   = output.Data.OPAQUE.TYPE;   transparent inline def Data   = output.Data
  type Text   = output.Text.OPAQUE.TYPE;   transparent inline def Text   = output.Text
  type Buffer = output.Buffer.OPAQUE.TYPE; transparent inline def Buffer = output.Buffer

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object OPAQUE  -> ###

   [[J.Output]] is an opaque value, backed by java.io.OutputStream

*/