package scalqa; package j; package io; import input.*; import language.implicitConversions

import Io.Input
import java.io.{ InputStream as REAL }

object Input extends AnyRef.Opaque.Base[Input, REAL]("Io.Input"):
  def apply(v: REAL)                                 : Input = v.toOpaque
  def apply(ba: Array[Byte])                         : Input = apply(java.io.ByteArrayInputStream(ba))
  def apply(ba: Array[Byte], offs: Int, length: Int) : Input = apply(java.io.ByteArrayInputStream(ba, offs, length))
  def apply(text: String)                            : Input = apply(text.getBytes)
  def apply(f: File.Path)                            : Input = apply(java.io.FileInputStream(f.real.toFile))

  @tn("getVoid") inline def void                     : Input = Z.Void
  implicit       inline def implicitRequest(v:VOID)  : Input = void
  implicit       inline def implicitFromReal(v: REAL): Input = apply(v)

  extension (x: Input)
    def asBytes : Bytes  = Bytes(x.real)
    def asData  : Data   = Data(x.real)
    def asText  : Text   = Text(x.real)
    def load    : Input  = { val v = Input(x.asBytes.readAll); x.close; v }

  object TYPE:
    opaque type DEF <: java.io.Closeable & AnyRef.Opaque = REAL & AnyRef.Opaque

  // Members ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  type Bytes = input.Bytes.TYPE.DEF; transparent inline def Bytes = input.Bytes
  type Data  = input.Data.TYPE.DEF;  transparent inline def Data  = input.Data
  type Text  = input.Text.TYPE.DEF;  transparent inline def Text  = input.Text


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

   [[J.Input]] is an opaque value, backed by java.io.InputStream

@def void  -> Get void instance

@def implicitRequest   -> General void instance request \n\n It is possible to use general request VOID to get void instance of this type, thanks to this implicit conversion.

*/