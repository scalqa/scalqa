package scalqa; package lang; package any; package z; import language.implicitConversions

abstract class OpaqueBase[A<: Any.Opaque]private[lang](name: String, ct: ClassTag[A]) extends `def`.TypeName[A] with `def`.Doc[A] with `def`.Void[A]:
  self =>
  val typeName          : String           = name
  def value_isVoid(v: A): Boolean
  def value_tag(v: A)   : String
  def value_doc(v: A)   : Doc

  given z_NameDef : Any.Def.TypeName[A] = self
  given z_Doc     : Any.Def.Doc[A]      = self
  given z_ClassTag: ClassTag[A]         = ct
  given z_CanEqual: CanEqual[A,A]       = CanEqual.derived

  // -------------------------------------------------------------------------------------------------------------------------------------
  private var ck = -1 // Checking if `doc` is called from `value_tag` (it may be overridden), if not, `value_tag` value is included in doc
  private[scalqa] def default_doc(v: A)   : Doc =
    if(ck<0) self.synchronized{ if(ck<0){ if(ck== -1){ ck= -2; value_tag(v); if(ck!=1) ck=0} else ck=1 }}
    val tg = ZZ.Any.value_tag(v)
    Doc(typeName+"@"+v.self.hash)
      ++= value_isVoid(v) ? ("","Void") += ("opaque",(v:Any).self.typeName+"("+tg+")")
      ++= ((ck==0) ? value_tag(v)).dropOnly(tg).map(v=>("tag",v))

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@val typeName -> Type name

    Returns defined opaque type name

@def value_tag -> Value to String

    Override this method to provide type custom convertion to String

@def value_doc -> Value to Doc

    Override this method to provide type custom [[scalqa.gen.Doc Doc]] implementation

@def value_isVoid -> Void check

    Override this method to define which instances of this type are void

    By default this method always returns `false`

    If type supports void instances, then following inmpelentation should be added in most cases:
    ```
      implicit inline def implicitRequest(v:VOID): OPAQUE_TYPE
    ```
*/
