package scalqa; package j; package io; package output; import language.implicitConversions

import Output.Data
import java.io.{ DataOutputStream as REAL }

object Data extends AnyRef.Opaque.Base[Data, REAL]("Io.Output.Data"):
  inline def apply(inline v: Io.Output): Data = new REAL(v.real).toOpaque

  extension (x: Data)
    inline def flush                      : Data = { x.real.flush;           x }
    inline def boolean(inline v: Boolean) : Data = { x.real.writeBoolean(v); x }
    inline def byte   (inline v: Int)     : Data = { x.real.writeByte(v);    x }
    inline def short  (inline v: Int)     : Data = { x.real.writeShort(v);   x }
    inline def char   (inline v: Int)     : Data = { x.real.writeChar(v);    x }
    inline def int    (inline v: Int)     : Data = { x.real.writeInt(v);     x }
    inline def long   (inline v: Long)    : Data = { x.real.writeLong(v);    x }
    inline def float  (inline v: Float)   : Data = { x.real.writeFloat(v);   x }
    inline def double (inline v: Double)  : Data = { x.real.writeDouble(v);  x }
    inline def byte   (inline v: String)  : Data = { x.real.writeBytes(v);   x }
    inline def char   (inline v: String)  : Data = { x.real.writeChars(v);   x }
    inline def utf    (inline v: String)  : Data = { x.real.writeUTF(v);     x }

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

   [[J.Output.Data]] is an opaque value, backed by java.io.DataOutputStream


@def boolean -> Write Boolean

      Writes a boolean value to this output stream

      If the argument v is true, the value (short)1 is written; if v is false, the value (short)0 is written

      The short written by this method may be read by the [[Input.Data.boolean]]


@def byte ->  Write Byte

      Writes to the output stream the eight low- order bits of the argument v

      The 24 high-order bits of v are ignored. (This means that writeByte does exactly the same thing as write for an integer argument.)

      The short written by this method may be read by the [[Input.Data.short]]


@def short -> Write Short

      Writes two byte to the output stream to represent the value of the argument

      The short values to be written, in the order shown, are:

       (short)(0xff & (v >> 8))

       (short)(0xff & v)

       The byte written by this method may be read by the [[Input.Data.short]]


@def char ->  Write Char

       Writes a char value, which is comprised of two byte, to the output stream

      The short values to be written, in the order shown, are:

      (short)(0xff & (v >> 8))

      (short)(0xff & v)

      The byte written by this method may be read by the [[Input.Data.char]]


@def int -> Write Int

      Writes an int value, which is comprised of four byte, to the output stream

      The short values to be written, in the order shown, are:

      (short)(0xff & (v >> 24))

      (short)(0xff & (v >> 16))

      (short)(0xff & (v >>    8))

      (short)(0xff & v)

      The byte written by this method may be read by the [[Input.Data.int]]


@def long -> Write Long

      Writes a long value, which is comprised of eight byte, to the output stream

      The short values to be written, in the order shown, are:

      (short)(0xff & (v >> 56))

      (short)(0xff & (v >> 48))

      (short)(0xff & (v >> 40))

      (short)(0xff & (v >> 32))

      (short)(0xff & (v >> 24))

      (short)(0xff & (v >> 16))

      (short)(0xff & (v >>  8))

      (short)(0xff & v)

      The byte written by this method may be read by the [[Input.Data.long]]


@def float -> Write Float

      Writes a float value, which is comprised of four byte, to the output stream

      It does this as if it first converts this float value to an int in exactly the manner of the Float.floatToIntBits method
      and then writes the int value in exactly the manner of the writeInt method

      The byte written by this method may be read by the [[Input.Data.float]]


@def double -> Write Double

      Writes a double value, which is comprised of eight byte, to the output stream

      It does this as if it first converts this double value to a long in exactly the manner of the
      Double.doubleToLongBits method and then writes the long value in exactly the manner of the writeLong method

      The byte written by this method may be read by the [[Input.Data.double]]


@def byte -> Write Bytes

      Writes a string to the output stream

      For every character in the string s, taken in order, one short is written to the output stream

      If s is null, a NullPointerException is thrown

      If s.length is zero, then no byte are written. Otherwise, the character s[0] is written first, then s[1], and so on; the last character written is s[s.length-1]

      For each character, one short is written, the low-order short, in exactly the manner of the writeByte method

      The high-order eight bits of each character in the string are ignored.


@def char -> Write Chars

      Writes every character in the string s, to the output stream, in order, two byte per character

      If s is null, a NullPointerException is thrown

      If s.length is zero, then no characters are written

      Otherwise, the character s[0] is written first, then s[1], and so on; the last character written is s[s.length-1]

      For each character, two byte are actually written, high-order short first, in exactly the manner of the writeChar method


@def utf -> Write UTF

     [[https://docs.oracle.com/javase/7/docs/api/java/io/DataOutput.html#writeUTF(java.lang.String) Details]]


*/
