package scalqa; package lang; package string; package opaque; import language.implicitConversions

import base.{ _Methods as X }

abstract class Base[A<:Opaque](typeName: String) extends AnyRef.Opaque.Base[A,String](typeName) with base._Methods:
  given ordering : Ordering[A] = String.ordering.cast[Ordering[A]]

  override def value_isVoid(v: A)           : Boolean = v.real.length==0
  override def value_tag(v: A)              : String  = typeName+":"+v
  implicit inline def implicitRequest(v: \/): A       = "".cast[A]

  given givenCanEqual_String: CanEqual[A,String] = CanEqual.derived

  extension[THIS_OPAQUE<:Opaque](inline x: THIS_OPAQUE)
    @tn("realString") inline def real: String = x.cast[String]

object Base:

  type _methods = base._Methods

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Base -> ### String Opaque Companion Object Base

  String Opaque Base by default inherits a large library of String methods.

  Note. Most opaque companions extend Opaque.Data, which also defines specialized containers attached to the type.

@def value_isVoid -> Void check

    Override this method to define which instances of this type are void

    By default String based opaque values are void if underlying String length equals to 0

*/
