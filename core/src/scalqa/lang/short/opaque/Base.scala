package scalqa;  package lang; package short; package opaque; import language.implicitConversions

abstract class Base[A<:Opaque](val typeName:String) extends Any.Opaque.Base[A](ClassTag.Short.cast[ClassTag[A]]) with Base._methods with gen.`given`.VoidDef.ShortRaw[A]:
  def value_isVoid(v: A): Boolean = false
  def value_tag(v: A)   : String  = default_doc(v).tag
  def value_doc(v: A)   : Doc     = default_doc(v)

  given givenVoidDef: Given.VoidDef.ShortRaw[A] = this

  extension(inline x: Short)
    inline def opaque[THIS_OPAQUE >: A <: A]: THIS_OPAQUE = x.cast[THIS_OPAQUE]

object Base:

  transparent trait _methods:
    extension[THIS_OPAQUE <: Opaque](inline x: ZZ) // Methods will be available from root library instead
      /**/       inline def real: Short              = J.unsupportedOperation()
      @tn("Opt") inline def ?   : G.Opt[THIS_OPAQUE] = J.unsupportedOperation()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Base -> ### Short Opaque Companion Object Base

  Opaque Base allows to create Scalqa basic opaque type, which can be processed by stream without boxing.

  Note. Most opaque companions extend Opaque.Data, which also defines specialized containers attached to the type.

@def value_isVoid -> Void check

    Override this method to define which instances of this type are void

    By default this method always returns `false`

    If type supports void instances, then following inmpelentation should be added in most cases:
    ```
      implicit inline def implicitRequest(v: \/) : (type) = (return void)
    ```

@def real -> Real value

     Returns Short value standing behind the opaque type.

     This is a zero cost call.

@def ? ->  To option

    Returns Short specialized option

*/
