package scalqa; package J; package Input

trait Data extends Z.Variety {

  def readFully(ba: Array[Byte])

  def readFully(ba: Array[Byte], off: Int, len: Int)

  def skipBytes(n: Int): Int

  def boolean: Boolean

  def byte: Byte

  def unsignedByte: Int

  def short: Short

  def unsignedShort: Int

  def char: Char

  def int: Int

  def long: Long

  def float: Float

  def double: Double

  def utf: String

}

object Data extends Input.Z.Variety.Companion[Data]
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @trait Data ->
 *
 *   [[Data]] view of parent [[Input]]
 *
 * @def boolean -> Read Boolean
 *
 *   Reads one input byte and returns true if that byte is nonzero, false if that byte is zero
 *
 *   This method is suitable for reading the byte written by the [[J.Output.Data.boolean]] method
 *
 * @def byte -> Read Boolean
 *
 *   Reads and returns one input byte. The byte is treated as a signed value in the range -128 through 127, inclusive
 *
 *   This method is suitable for reading the byte written by the [[J.Output.Data.byte]] method
 *
 * @def unsignedByte -> Read unsignedByte
 *
 *   Reads one input byte, zero-extends it to type int, and returns the result, which is therefore in the range 0 through 255
 *
 *   This method is suitable for reading the byte written by the [[J.Output.Data.byte]] method if the argument to writeByte was intended to be a value in the range 0 through 255
 *
 * @def short -> Read Short
 *
 *   Reads two input bytes and returns a short value. Let a be the first byte read and b be the second byte
 *
 *   The value returned is: (short)((a << 8) | (b & 0xff))
 *
 *   This method is suitable for reading the bytes written by the [[J.Output.Data.short]] method
 *
 * @def unsignedShort -> Read unsignedShort
 *
 *   Reads two input bytes and returns an int value in the range 0 through 65535. Let a be the first byte read and b be the second byte
 *
 *   The value returned is: (((a & 0xff) << 8) | (b & 0xff))
 *
 *   This method is suitable for reading the bytes written by the [[J.Output.Data.short]] method if the argument to [[J.Output.Data.short]] was intended to be a value in the range 0 through 65535
 *
 * @def char -> Read Char
 *
 *    Reads two input bytes and returns a char value. Let a be the first byte read and b be the second byte
 *
 *    The value returned is: (char)((a << 8) | (b & 0xff))
 *
 *    This method is suitable for reading bytes written by the [[J.Output.Data.char]] method
 *
 * @def long -> Read Long
 *
 *    Reads eight input bytes and returns a long value. Let a-h be the first through eighth bytes read. The value returned is:
 *
 *    (((long)(a & 0xff) << 56) |
 *    ((long)(b & 0xff) << 48) |
 *    ((long)(c & 0xff) << 40) |
 *    ((long)(d & 0xff) << 32) |
 *    ((long)(e & 0xff) << 24) |
 *    ((long)(f & 0xff) << 16) |
 *    ((long)(g & 0xff) <<  8) |
 *    ((long)(h & 0xff)))
 *
 *    This method is suitable for reading bytes written by the [[J.Output.Data.long]] method
 *
 * @def int -> Read Int
 *
 *    Reads four input bytes and returns an int value. Let a-d be the first through fourth bytes read. The value returned is:
 *
 *     (((a & 0xff) << 24) | ((b & 0xff) << 16) |
 *    ((c & 0xff) << 8) | (d & 0xff))
 *
 *    This method is suitable for reading bytes written by the [[J.Output.Data.int]] method
 *
 * @def float -> Read Float
 *
 *    Reads four input bytes and returns a float value.
 *
 *    It does this by first constructing an int value in exactly the manner of the readInt method,
 *    then converting this int value to a float in exactly the manner of the method Float.intBitsToFloat
 *
 *     This method is suitable for reading bytes written by the [[J.Output.Data.float]] method
 *
 * @def double -> Read Double
 *
 *    Reads eight input bytes and returns a double value
 *
 *    It does this by first constructing a long value in exactly the manner of the readlong method,
 *    then converting this long value to a double in exactly the manner of the method Double.longBitsToDouble
 *
 *    This method is suitable for reading bytes written by the [[J.Output.Data.double]] method of interface DataOutput
 *
 * @def utf -> Read UTF String
 *
 *    [[https://docs.oracle.com/javase/7/docs/api/java/io/DataInput.html#readUTF() Details]]
 *
 *    The [[J.Output.Data.utf]] method may be used to write data that is suitable for reading by this method
 *
 */
