package scalqa; package gen; package `given`; package z; import language.implicitConversions

class ArrayDoc extends Given.DocDef[Object]:

  def value_tag(v: Object) = value_doc(v).tag

  def value_doc(v: Object): Doc =
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
      case v                 => return Doc(v.toString)
    if(b) Doc(name) += "emptySingleton"
    else  Doc(name + "@" + v.^.hash) += ("size",len)

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
