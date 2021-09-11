package scalqa; package j; package io; package input; import language.implicitConversions

import Input.Data
import java.io.{ DataInputStream as REAL }

object Data extends AnyRef.Opaque.Base[Data, REAL]("Io.Input.Data"):
  inline def apply(inline v: Io.Input): Data = new REAL(v.real).toOpaque

  extension(inline x: Data)
    inline def readFully(inline ba: Array[Byte])                                    : Unit     = x.real.readFully(ba)
    inline def readFully(inline ba: Array[Byte], inline from:Int, inline size: Int) : Unit     = x.real.readFully(ba, from, size)
    inline def skipBytes(inline n: Int)                                             : Int      = x.real.skipBytes(n)
    inline def boolean                                                              : Boolean  = x.real.readBoolean
    inline def byte                                                                 : Byte     = x.real.readByte
    inline def unsignedByte                                                         : Int      = x.real.readUnsignedByte
    inline def short                                                                : Short    = x.real.readShort
    inline def unsignedShort                                                        : Int      = x.real.readUnsignedShort
    inline def char                                                                 : Char     = x.real.readChar
    inline def int                                                                  : Int      = x.real.readInt
    inline def long                                                                 : Long     = x.real.readLong
    inline def float                                                                : Float    = x.real.readFloat
    inline def double                                                               : Double   = x.real.readDouble
    inline def utf                                                                  : String   = x.real.readUTF

  object TYPE:
    opaque type DEF <: java.io.Closeable & AnyRef.Opaque = java.io.InputStream & AnyRef.Opaque

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@type DEF  -> ###

   [[J.Input.Data]] is an opaque value, backed by java.io.DataInputStream

@def boolean -> Read Boolean

     Reads and returns one input short. The short is treated as a signed value in the range -128 through 127, inclusive

     This method is suitable for reading the short written by the [[J.Output.Data.short]] method


@def unsignedByte -> Read unsignedByte

     Reads one input short, zero-extends it to type int, and returns the result, which is therefore in the range 0 through 255

     This method is suitable for reading the short written by the [[J.Output.Data.short]] method if the argument to writeByte was intended to be a value in the range 0 through 255


@def short -> Read Short

     Reads two input byte and returns a short value. Let a be the first short read and b be the second short

     The value returned is: (short)((a << 8) | (b & 0xff))

     This method is suitable for reading the byte written by the [[J.Output.Data.short]] method


@def unsignedShort -> Read unsignedShort

     Reads two input byte and returns an int value in the range 0 through 65535. Let a be the first short read and b be the second short

     The value returned is: (((a & 0xff) << 8) | (b & 0xff))

     This method is suitable for reading the byte written by the [[J.Output.Data.short]] method if the argument to [[J.Output.Data.short]] was intended to be a value in the range 0 through 65535


@def char -> Read Char

      Reads two input byte and returns a char value. Let a be the first short read and b be the second short

      The value returned is: (char)((a << 8) | (b & 0xff))

      This method is suitable for reading byte written by the [[J.Output.Data.char]] method


@def long -> Read Long

      Reads eight input byte and returns a long value. Let a-h be the first through eighth byte read. The value returned is:

      (((long)(a & 0xff) << 56) |
      ((long)(b & 0xff) << 48) |
      ((long)(c & 0xff) << 40) |
      ((long)(d & 0xff) << 32) |
      ((long)(e & 0xff) << 24) |
      ((long)(f & 0xff) << 16) |
      ((long)(g & 0xff) <<  8) |
      ((long)(h & 0xff)))

      This method is suitable for reading byte written by the [[J.Output.Data.long]] method


@def int -> Read Int

      Reads four input byte and returns an int value. Let a-d be the first through fourth byte read. The value returned is:

       (((a & 0xff) << 24) | ((b & 0xff) << 16) |
      ((c & 0xff) << 8) | (d & 0xff))

      This method is suitable for reading byte written by the [[J.Output.Data.int]] method


@def float -> Read Float

      Reads four input byte and returns a float value.

      It does this by first constructing an int value in exactly the manner of the readInt method,
      then converting this int value to a float in exactly the manner of the method Float.intBitsToFloat

       This method is suitable for reading byte written by the [[J.Output.Data.float]] method


@def double -> Read Double

      Reads eight input byte and returns a double value

      It does this by first constructing a long value in exactly the manner of the readlong method,
      then converting this long value to a double in exactly the manner of the method Double.longBitsToDouble

      This method is suitable for reading byte written by the [[J.Output.Data.double]] method of interface DataOutput


@def utf -> Read UTF String

      [[https://docs.oracle.com/javase/7/docs/api/java/io/DataInput.html#readUTF() Details]]

      The [[J.Output.Data.utf]] method may be used to write data that is suitable for reading by this method


*/
