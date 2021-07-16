package scalqa; package lang; package string; package custom; import language.implicitConversions

import `type`.{ _Methods as X }

abstract class Type[A<:Opaque.String](typeName: String) extends Any.Ref.Custom.Type[A,String](typeName) with Type._methods[A]:
  given ordering : Ordering[A] = String.ordering.cast[Ordering[A]]

  override def isVoid(v: A)                   : Boolean = v.real.length==0
  override def tag(v: A)                      : String  = typeName+":"+v
  implicit inline def implicitRequest(inline v: \/) : A       = "".cast[A]

  given givenCanEqual_String: CanEqual[A,String] = CanEqual.derived

object Type:

  transparent trait _methods[A<:Opaque.String] extends X._evaluate[A] with X._modify[A] with X._copy[A] with X._transform[A]

  object _methods:
    type _evaluate [A<:Opaque.String] = X._evaluate[A]
    type _modify   [A<:Opaque.String] = X._modify[A]
    type _copy     [A<:Opaque.String] = X._copy[A]
    type _transform[A<:Opaque.String] = X._transform[A]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Type -> ### String Custom Type Setup

  String Custom Type by default inherits a large library of String methods.

@trait _methods -> ### Default Methods

    This is the same set of methods as [String._methods](../_methods.html), but customized for defined type

*/
