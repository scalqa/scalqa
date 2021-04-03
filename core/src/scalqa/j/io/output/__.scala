package scalqa; package j; package io; import output.*; import language.implicitConversions

import Io.Output

object Output extends Any.Ref.Custom.Type[Output, java.io.OutputStream]("Io.Output"):
  inline def apply(inline v: java.io.OutputStream): Output = v.asOpaque[Output]
  /**/   def apply(f: File.Path)                  : Output = apply(java.io.FileOutputStream(f.real.toFile))

  extension (x: Output)
    def asBytes   : Output.Bytes          = Bytes(x)
    def asText    : Text                  = Text(x)
    def asData    : Data                  = Data(x)
    def asPrinter : java.io.PrintStream   = java.io.PrintStream(x.real)
    def flush     : Output                = { x.real.flush; x }

  object opaque:
    opaque type `type` <: java.io.Closeable & Opaque.Ref = java.io.OutputStream & Opaque.Ref

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Bytes  = output.Bytes.opaque.`type`;  inline def Bytes  = output.Bytes
  type Data   = output.Data.opaque.`type`;   inline def Data   = output.Data
  type Text   = output.Text.opaque.`type`;   inline def Text   = output.Text
  type Buffer = output.Buffer.opaque.`type`; inline def Buffer = output.Buffer

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Output]] is an opaque value, backed by java.io.OutputStream

*/