package scalqa; package lang; package anyref; package opaque; import language.implicitConversions

abstract class Base[A<:Opaque, REAL<:AnyRef](val typeName: String)(using ct: ClassTag[REAL]) extends Any.Opaque.Base[A](ct.cast[ClassTag[A]]) with Base._methods[A,REAL]:

  def value_isVoid(v: A): Boolean = false
  def value_tag(v: A)   : String  = default_doc(v).tag
  def value_doc(v: A)   : Doc     = default_doc(v)

  given givenDocDef : Given.DocDef[A]  = this
  given givenVoidDef: Given.VoidDef[A] = this

  extension[B>:REAL<:REAL](inline x: B)
    inline def opaque[THIS_OPAQUE >: A <: A]: THIS_OPAQUE = x.cast[THIS_OPAQUE]

object Base:

  transparent trait _methods[A<:Opaque, REAL<:AnyRef]:
    extension[THIS_OPAQUE<:A](inline x: THIS_OPAQUE)
      inline def real[REAL_TYPE >: REAL <: REAL]: REAL_TYPE = x.cast[REAL_TYPE]

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Base -> ### AnyRef Opaque Companion Object Base

  Opaque Base allows to create Scalqa basic opaque type.

@def real -> Real value

     Returns real value standing behind the opaque type.

     This is a zero cost call.

*/