package scalqa; package Array; package Z

private[scalqa] object Raw {

  @inline def getBoolean(s: Int): Array.Raw[Boolean] = if (s == 0) scala.Array.emptyBooleanArray else new Array.Raw[Boolean](s)

  @inline def getByte(s: Int): Array.Raw[Byte] = if (s == 0) scala.Array.emptyByteArray else new Array.Raw[Byte](s)

  @inline def getChar(s: Int): Array.Raw[Char] = if (s == 0) scala.Array.emptyCharArray else new Array.Raw[Char](s)

  @inline def getShort(s: Int): Array.Raw[Short] = if (s == 0) scala.Array.emptyShortArray else new Array.Raw[Short](s)

  @inline def getInt(s: Int): Array.Raw[Int] = if (s == 0) scala.Array.emptyIntArray else new Array.Raw[Int](s)

  @inline def getLong(s: Int): Array.Raw[Long] = if (s == 0) scala.Array.emptyLongArray else new Array.Raw[Long](s)

  @inline def getFloat(s: Int): Array.Raw[Float] = if (s == 0) scala.Array.emptyFloatArray else new Array.Raw[Float](s)

  @inline def getDouble(s: Int): Array.Raw[Double] = if (s == 0) scala.Array.emptyDoubleArray else new Array.Raw[Double](s)

  @inline def getObject(s: Int): Array.Raw[AnyRef] = if (s == 0) scala.Array.emptyObjectArray else new Array.Raw[AnyRef](s)

  def toString(r: Array.Raw[_]) = r.I.toString match {
    case s if s.startsWith("[I@") => "IntArray@" + s.copyFrom(3)
    case s if s.startsWith("[D@") => "DoubleArray@" + s.copyFrom(3)
    case s if s.startsWith("[F@") => "FloatArray@" + s.copyFrom(3)
    case s if s.startsWith("[C@") => "CharArray@" + s.copyFrom(3)
    case s if s.startsWith("[Z@") => "BooleanArray@" + s.copyFrom(3)
    case s if s.startsWith("[B@") => "ByteArray@" + s.copyFrom(3)
    case s if s.startsWith("[J@") => "LongArray@" + s.copyFrom(3)
    case s if s.startsWith("[S@") => "ShortArray@" + s.copyFrom(3)
    case s if s.startsWith("[L") => "Array[" + s.copyFrom(2).replace(";@", "]@")
    case s => s
  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/