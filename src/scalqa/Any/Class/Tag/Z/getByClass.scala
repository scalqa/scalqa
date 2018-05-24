package scalqa; package Any; package Class; package Tag; package Z

private[Class] object getByClass {

  def apply[A](c: Class[A]): Tag[_] = c.real match {
    case v if (Any.Value.Class.isAssignableFrom(v)) =>
      if (Any.Value.Ref.Class.isAssignableFrom(v)) RefValue
      else if (Any.Value.Int.Class.isAssignableFrom(v)) IntValue
      else if (Any.Value.Long.Class.isAssignableFrom(v)) LongValue
      else if (Any.Value.Double.Class.isAssignableFrom(v)) DoubleValue
      else if (Any.Value.Byte.Class.isAssignableFrom(v)) ByteValue
      else if (Any.Value.Char.Class.isAssignableFrom(v)) CharValue
      else if (Any.Value.Short.Class.isAssignableFrom(v)) ShortValue
      else if (Any.Value.Float.Class.isAssignableFrom(v)) FloatValue
      else Fail()
    case v if (v.isPrimitive) => v match {
      case scalqa.Boolean.ClassPrimitive => Boolean
      case scalqa.Byte.ClassPrimitive => Byte
      case scalqa.Char.ClassPrimitive => Char
      case scalqa.Short.ClassPrimitive => Short
      case scalqa.Int.ClassPrimitive => Int
      case scalqa.Long.ClassPrimitive => Long
      case scalqa.Float.ClassPrimitive => Float
      case scalqa.Double.ClassPrimitive => Double
      case _ => Fail()
    }
    case scalqa.Boolean.Class => Boolean
    case scalqa.Byte.Class    => Byte
    case scalqa.Char.Class    => Char
    case scalqa.Short.Class   => Short
    case scalqa.Int.Class     => Int
    case scalqa.Long.Class    => Long
    case scalqa.Float.Class   => Float
    case scalqa.Double.Class  => Double
    case _                    => AnyRef
  }

  //    case java.lang.Byte.TYPE      => Byte.newArrayRaw(len)
  //    case java.lang.Short.TYPE     => Short.newArrayRaw(len)
  //    case java.lang.Character.TYPE => Char.newArrayRaw(len)
  //    case java.lang.Integer.TYPE   => Int.newArrayRaw(len)
  //    case java.lang.Long.TYPE      => Long.newArrayRaw(len)
  //    case java.lang.Float.TYPE     => Float.newArrayRaw(len)
  //    case java.lang.Double.TYPE    => Double.newArrayRaw(len)
  //    case java.lang.Boolean.TYPE   => Boolean.newArrayRaw(len)
  //    case java.lang.Void.TYPE      => new Array.Raw[Unit](len)
  //    case _                => AnyRef.newArrayRaw(len)

}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/