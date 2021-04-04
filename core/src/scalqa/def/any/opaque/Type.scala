package scalqa; package `def`; package any; package opaque; import language.implicitConversions

abstract class Type[A<:Opaque]private[`def`](ct: ClassTag[A]) extends self.info.tag.Type[A] with self.info.tag.Void[A] with self.info.Tag[A]:
  self =>
  given xxTagType  : Info.Tag.Type[A] = self
  given xxInfoTag  : Info.Tag[A]  = self
  given xxTagClass: ClassTag[A]      = ct
  given xxCanEqual: CanEqual[A,A]    = CanEqual.derived

  def isVoid(v: A): Boolean = false
  def tag(v: A)   : String  = info(v).tag

  private var ck = -1 // Checking if `info` is called from `tag` (it may be overridden), if not, `tag` value is included in info
  def info(v: A): Info =
     if(ck<0) self.synchronized{ if(ck<0){ if(ck== -1){ ck= -2; tag(v); if(ck!=1) ck=0} else ck=1 }}
     val dt = ZZ.Tag.tag(v)
     Info(name+"@"+v.self_^.hash) += isVoid(v) ? ("","Void") += ("opaque",(v:Any).^.kind+"("+dt+")") ++= ((ck==0) ? tag(v)).dropOnly(dt).map(v=>("tag",v)).~

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@def tag -> Type to String

    Override this method to provide type standard convertion to String

@def info -> Type to Info

    Override this method to provide type standard [[scalqa.gen.Info Info]] implementation

@def isVoid -> Void check

    Override this method to define which instances of this type are void

    By default this method always returns `false`

    If type supports void instances, then following inmpelentation should be added in most cases:
    ```
      implicit inline def xxRequest(inline v: \/) : <type> = <return void>
    ```
*/