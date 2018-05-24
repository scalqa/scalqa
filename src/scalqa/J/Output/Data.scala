package scalqa; package J; package Output

trait Data extends Z.Like {

  def boolean(v: Boolean): this.type

  def byte(v: Int): this.type

  def short(v: Int): this.type

  def char(v: Int): this.type

  def int(v: Int): this.type

  def long(v: Long): this.type

  def float(v: Float): this.type

  def double(v: Double): this.type

  def bytes(v: String): this.type

  def chars(v: String): this.type

  def utf(v: String): this.type

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 *
 * @def boolean -> Write Boolean
 *
 *    Writes a boolean value to this output stream
 *
 *    If the argument v is true, the value (byte)1 is written; if v is false, the value (byte)0 is written
 *
 *    The byte written by this method may be read by the [[Input.Data.boolean]]
 *
 * @def byte( -> Write Byte
 *
 *    Writes to the output stream the eight low- order bits of the argument v
 *
 *    The 24 high-order bits of v are ignored. (This means that writeByte does exactly the same thing as write for an integer argument.)
 *
 *    The byte written by this method may be read by the [[Input.Data.byte]]
 *
 * @def short -> Write Short
 *
 *    Writes two bytes to the output stream to represent the value of the argument
 *
 *    The byte values to be written, in the order shown, are:
 *
 *     (byte)(0xff & (v >> 8))
 *
 *     (byte)(0xff & v)
 *
 *     The bytes written by this method may be read by the [[Input.Data.short]]
 *
 * @def char( -> Write Char
 *
 *     Writes a char value, which is comprised of two bytes, to the output stream
 *
 *    The byte values to be written, in the order shown, are:
 *
 *    (byte)(0xff & (v >> 8))
 *
 *    (byte)(0xff & v)
 *
 *    The bytes written by this method may be read by the [[Input.Data.char]]
 *
 * @def int -> Write Int
 *
 *    Writes an int value, which is comprised of four bytes, to the output stream
 *
 *    The byte values to be written, in the order shown, are:
 *
 *    (byte)(0xff & (v >> 24))
 *
 *    (byte)(0xff & (v >> 16))
 *
 *    (byte)(0xff & (v >>    8))
 *
 *    (byte)(0xff & v)
 *
 *    The bytes written by this method may be read by the [[Input.Data.int]]
 *
 * @def long -> Write Long
 *
 *    Writes a long value, which is comprised of eight bytes, to the output stream
 *
 *    The byte values to be written, in the order shown, are:
 *
 *    (byte)(0xff & (v >> 56))
 *
 *    (byte)(0xff & (v >> 48))
 *
 *    (byte)(0xff & (v >> 40))
 *
 *    (byte)(0xff & (v >> 32))
 *
 *    (byte)(0xff & (v >> 24))
 *
 *    (byte)(0xff & (v >> 16))
 *
 *    (byte)(0xff & (v >>  8))
 *
 *    (byte)(0xff & v)
 *
 *    The bytes written by this method may be read by the [[Input.Data.long]]
 *
 * @def float -> Write Float
 *
 *    Writes a float value, which is comprised of four bytes, to the output stream
 *
 *    It does this as if it first converts this float value to an int in exactly the manner of the Float.floatToIntBits method
 *    and then writes the int value in exactly the manner of the writeInt method
 *
 *    The bytes written by this method may be read by the [[Input.Data.float]]
 *
 * @def double -> Write Double
 *
 *    Writes a double value, which is comprised of eight bytes, to the output stream
 *
 *    It does this as if it first converts this double value to a long in exactly the manner of the
 *    Double.doubleToLongBits method and then writes the long value in exactly the manner of the writeLong method
 *
 *    The bytes written by this method may be read by the [[Input.Data.double]]
 *
 * @def bytes -> Write Bytes
 *
 *    Writes a string to the output stream
 *
 *    For every character in the string s, taken in order, one byte is written to the output stream
 *
 *    If s is null, a NullPointerException is thrown
 *
 *    If s.length is zero, then no bytes are written. Otherwise, the character s[0] is written first, then s[1], and so on; the last character written is s[s.length-1]
 *
 *    For each character, one byte is written, the low-order byte, in exactly the manner of the writeByte method
 *
 *    The high-order eight bits of each character in the string are ignored.
 *
 * @def chars -> Write Chars
 *
 *    Writes every character in the string s, to the output stream, in order, two bytes per character
 *
 *    If s is null, a NullPointerException is thrown
 *
 *    If s.length is zero, then no characters are written
 *
 *    Otherwise, the character s[0] is written first, then s[1], and so on; the last character written is s[s.length-1]
 *
 *    For each character, two bytes are actually written, high-order byte first, in exactly the manner of the writeChar method
 *
 * @def utf -> Write UTF
 *
 *   [[https://docs.oracle.com/javase/7/docs/api/java/io/DataOutput.html#writeUTF(java.lang.String) Details]]
 *
 */
