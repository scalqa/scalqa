package scalqa; package lang; package any; package opaque; import language.implicitConversions

abstract class Base[A<: Any.Opaque]private[lang](ct: ClassTag[A]) extends gen.`given`.TypeDef[A] with gen.`given`.DocDef[A] with gen.`given`.VoidDef[A]:
  self =>
  given givenTypeDef : Given.TypeDef[A] = self
  given givenDocDef  : Given.DocDef[A]  = self
  given givenClassTag: ClassTag[A]      = ct
  given givenCanEqual: CanEqual[A,A]    = CanEqual.derived

  def value_isVoid(v: A): Boolean
  def value_tag(v: A)   : String
  def value_doc(v: A)   : Doc

  // -------------------------------------------------------------------------------------------------------------------------------------
  private var ck = -1 // Checking if `doc` is called from `value_tag` (it may be overridden), if not, `value_tag` value is included in doc
  private[scalqa] def default_doc(v: A)   : Doc =
    if(ck<0) self.synchronized{ if(ck<0){ if(ck== -1){ ck= -2; value_tag(v); if(ck!=1) ck=0} else ck=1 }}
    val tg = ZZ.Def.value_tag(v)
    Doc(typeName+"@"+v.self_^.hash)
      ++= value_isVoid(v) ? ("","Void") += ("opaque",(v:Any).^.typeName+"("+tg+")")
      ++= ((ck==0) ? value_tag(v)).dropOnly(tg).map(v=>("tag",v))

object Base:

  transparent trait _methods:
    extension[THIS_OPAQUE<:Any.Opaque](inline x: THIS_OPAQUE)
      inline def real[REAL_TYPE]: REAL_TYPE

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Base -> ### Any Opaque Companion Object Base

    This class cannot be used directly, but rather through it's children like
    [Int.Opaque.Base](../../int/opaque/Base.html), [Char.Opaque.Data](../../char/opaque/Data.html), etc.

@def value_tag -> Value to String

    Override this method to provide type custom convertion to String

@def value_doc -> Value to Doc

    Override this method to provide type custom [[scalqa.gen.Doc Doc]] implementation

@def value_isVoid -> Void check

    Override this method to define which instances of this type are void

    By default this method always returns `false`

    If type supports void instances, then following inmpelentation should be added in most cases:
    ```
      implicit inline def implicitRequest(v: \/) : (type) = (return void)
    ```
@def real -> Real value

     All Scalqa opaque types have a method to return underlying value.

     This is a zero cost call.
*/
