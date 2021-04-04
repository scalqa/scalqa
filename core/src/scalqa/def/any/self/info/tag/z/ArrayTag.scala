package scalqa; package `def`; package any; package self; package info; package tag; package z; import language.implicitConversions

class ArrayTag extends Tag[Object]:
  def tag(v: Object) = info(v).tag
  def info(v: Object): Info =
    val (name,b,len) = v match
      case v: Array[Int]     => ("Array[Int]",    v eq ZZ.emptyIntArray,     v.length)
      case v: Array[Double]  => ("Array[Double]", v eq ZZ.emptyDoubleArray,  v.length)
      case v: Array[Float]   => ("Array[Float]",  v eq ZZ.emptyFloatArray,   v.length)
      case v: Array[Char]    => ("Array[Char]",   v eq ZZ.emptyCharArray,    v.length)
      case v: Array[Boolean] => ("Array[Boolean]",v eq ZZ.emptyBooleanArray, v.length)
      case v: Array[Byte]    => ("Array[Byte]",   v eq ZZ.emptyByteArray,    v.length)
      case v: Array[Long]    => ("Array[Long]",   v eq ZZ.emptyLongArray,    v.length)
      case v: Array[Short]   => ("Array[Short]",  v eq ZZ.emptyShortArray,   v.length)
      case v: Array[Object]  =>
          val s = v.toString
          (s.startsWith("[Ljava.lang.Object") ? "Array[Object]" or "Array[" + s.dropFirst(2).takeBefore(";@") + "]", v eq ZZ.emptyObjectArray, v.length)
      case v                 => return Info(v.toString)
    if(b) Info(name) += "emptySingleton"
    else  Info(name + "@" + v.^.hash) += ("size",len)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
