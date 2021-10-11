package scalqa;  package lang; package float; package opaque; import language.implicitConversions

abstract class Base[A<:Opaque](name:String) extends any.z.OpaqueBase[A](name,ClassTag.Float.cast[ClassTag[A]]) with Base._methods with any.`def`.Void.Primitive.X.Float[A]:
  def value_isVoid(v: A): Boolean = false
  def value_tag(v: A)   : String  = default_doc(v).tag
  def value_doc(v: A)   : Doc     = default_doc(v)

  given z_VoidDef: Any.Def.Void.Primitive.X.Float[A] = this

  extension(inline x: Float)
    inline def toOpaque[THIS_OPAQUE >: A <: A]: THIS_OPAQUE = x.cast[THIS_OPAQUE]

object Base:

  transparent trait _methods:
    extension[THIS_OPAQUE <: Opaque](inline x: ZZ) // Methods will be available from root library instead
      /**/       inline def real: Float              = J.unsupportedOperation()
      @tn("Opt") inline def ?   : G.Opt[THIS_OPAQUE] = J.unsupportedOperation()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Base -> ### Float Opaque Companion Object Base

  Opaque Base allows to create basic opaque type, which can be recognized and processed by stream without boxing.

  Note. Most opaque companions extend Opaque.Data, which also defines specialized containers attached to the type.

  See [sample type definition](https://github.com/scalqa/samples/blob/master/src/example/opaque/all/OpaqueFloat.scala).

@trait _methods -> Default methods for all Float.Opaque.Base defined types

@def value_tag -> Value to String

    Override this method to provide type custom convertion to String

@def value_doc -> Value to Doc

    Override this method to provide type custom [[scalqa.gen.Doc Doc]] implementation

@def value_isVoid -> Void check

    Override this method to define which instances of this type are void

    By default this method always returns `false`

    If type supports void instances, then following inmpelentation should be added in most cases:
    ```
      implicit inline def implicitRequest(v: \/): OPAQUE_TYPE
    ```

@def real -> Real value

     Returns Float value standing behind the opaque type.

     This is a zero cost call.

@def ? ->  To option

    Returns Float specialized option

*/
