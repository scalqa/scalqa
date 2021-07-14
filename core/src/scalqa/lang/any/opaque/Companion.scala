package scalqa; package lang; package any; package opaque; import language.implicitConversions

abstract class Companion[A<:Opaque]private[lang](ct: ClassTag[A]) extends gen.`given`.TypeTag[A] with gen.`given`.DocTag[A] with gen.`given`.VoidTag[A]:
  self =>
  given givenTypeTag : Given.TypeTag[A]  = self
  given givenDocTag  : Given.DocTag[A]   = self
  given givenClassTag: ClassTag[A]   = ct
  given givenCanEqual: CanEqual[A,A] = CanEqual.derived

  def isVoid(v: A): Boolean = false
  def tag(v: A)   : String  = doc(v).tag

  private var ck = -1 // Checking if `doc` is called from `tag` (it may be overridden), if not, `tag` value is included in doc
  def doc(v: A): Doc      =
     if(ck<0) self.synchronized{ if(ck<0){ if(ck== -1){ ck= -2; tag(v); if(ck!=1) ck=0} else ck=1 }}
     val dt = ZZ.Tag.tag(v)
     Doc(typeName+"@"+v.self_^.hash) ++= isVoid(v) ? ("","Void") += ("opaque",(v:Any).^.typeName+"("+dt+")") ++= ((ck==0) ? tag(v)).dropOnly(dt).map(v=>("tag",v))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Companion -> Base type for all Opaque companion objects.

    This class cannot be used directly, but rather through it's children like
    [Int.Custom.Type](../../int/custom/Type.html), [Char.Custom.Data](../../char/custom/Data.html), etc.

@def tag -> Type to String

    Override this method to provide type custom convertion to String

@def doc -> Type to Doc

    Override this method to provide type custom [[scalqa.gen.Doc Doc]] implementation

@def isVoid -> Void check

    Override this method to define which instances of this type are void

    By default this method always returns `false`

    If type supports void instances, then following inmpelentation should be added in most cases:
    ```
      implicit inline def implicitRequest(inline v: \/) : <type> = <return void>
    ```
*/