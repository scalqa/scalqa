package scalqa; package j; package io; import input.*; import language.implicitConversions

import Io.Input

object Input extends Any.Ref.Custom.Type[Input, java.io.InputStream]("Io.Input"):
  def apply(v: java.io.InputStream)                     : Input = v.asOpaque[Input]
  def apply(ba: Array[Byte])                            : Input = apply(java.io.ByteArrayInputStream(ba))
  def apply(ba: Array[Byte], offs: Int, length: Int)    : Input = apply(java.io.ByteArrayInputStream(ba, offs, length))
  def apply(text: String)                               : Input = apply(text.getBytes)
  def apply(f: File.Path)                               : Input = apply(java.io.FileInputStream(f.real.toFile))

  implicit inline def implicitFromJava(v: java.io.InputStream): Input = apply(v)

  @tn("getVoid") inline def void                        : Input = Z.Void
  implicit       inline def implicitRequestVoid(inline v: \/)     : Input = void

  extension (x: Input)
    def asBytes : Input.Bytes = Input.Bytes(x.real)
    def asData  : Data        = Data(x.real)
    def asText  : Text        = Text(x.real)
    def load    : Input       = { val v = Input(x.asBytes.readAll); x.close; v }

  object opaque:
    opaque type `type` <: java.io.Closeable & Opaque.Ref = java.io.InputStream & Opaque.Ref
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Bytes = input.Bytes.opaque.`type`; inline def Bytes = input.Bytes
  type Data  = input.Data.opaque.`type`;  inline def Data  = input.Data
  type Text  = input.Text.opaque.`type`;  inline def Text  = input.Text


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@object opaque -> ###

   [[J.Input]] is an opaque value, backed by java.io.InputStream

@def void  -> Get void instance

@def implicitRequestVoid -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/