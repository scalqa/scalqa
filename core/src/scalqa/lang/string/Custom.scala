package scalqa; package lang; package string; import language.implicitConversions

import string.{ _Extension as X }

object Custom:

  abstract class Data[A<:Opaque.String](typeName: String) extends Type[A](typeName) with Any.Ref.Custom.Framework[A]

  abstract class Type[A<:Opaque.String](typeName: String) extends Any.Ref.Custom.Type[A,String](typeName) with  X._evaluate[A] with X._modify[A] with X._copy[A] with X._transform[A] with z.Lib[A]:
    given ordering : Ordering[A] = String.ordering.cast[Ordering[A]]

    override def isVoid(v: A)                   : Boolean = v.real.length==0
    override def tag(v: A)                      : String  = name+":"+v
    implicit inline def implicitRequestVoid(inline v: \/) : A       = "".cast[A]

    given givenCanEqual_String: CanEqual[A,String] = CanEqual.derived

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
