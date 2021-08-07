package scalqa; package j; package io; package input; import language.implicitConversions

object Z:

  // ***************************************************************
  class CharStream(r: java.io.Reader) extends Char.~ :

    @tn("readRaw_Opt") def readRaw_? =
      var o: Char.Opt = \/
      val v = r.read
      if(v >= 0) o = v.toChar
      o

  // ***************************************************************
  object Void extends java.io.InputStream with Gen.Void:
    def read = -1


  // -------------------------------------------------------------------------------------------------------------------------------
  def toByteArray(in: Input.Bytes): Array[Byte] =
    var a, buf = new Array[Byte](1000)
    var len = 0
    var i = in.read(buf)
    while (i != -1)
      while (a.length <= len) a = a.copySize(len*2)
      buf.copyTo(a, len, 0, i)
      len += i
      i = in.read(buf)
    a.copySize(len)


  // -------------------------------------------------------------------------------------------------------------------------------
  def readString(x: Input.Text, size: Int): String =
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

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
