package scalqa; package Custom; package Array; package Z

private[scalqa] object toString {

  def apply[A](a: Array[A]): String = a.I.toString match {
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
