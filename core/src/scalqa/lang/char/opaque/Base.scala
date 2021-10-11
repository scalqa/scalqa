package scalqa;  package lang; package char; package opaque; import language.implicitConversions

abstract class Base[A<:Opaque](name:String) extends any.z.OpaqueBase[A](name,ClassTag.Char.cast[ClassTag[A]]) with Base._methods with any.`def`.Void.Primitive.X.Char[A]:
  def value_isVoid(v: A): Boolean = false
  def value_tag(v: A)   : String  = default_doc(v).tag
  def value_doc(v: A)   : Doc     = default_doc(v)

  given z_VoidDef: Any.Def.Void.Primitive.X.Char[A] = this

  extension(inline x: Char)
    inline def toOpaque[THIS_OPAQUE >: A <: A]: THIS_OPAQUE = x.cast[THIS_OPAQUE]

object Base:

  transparent trait _methods:
    extension[THIS_OPAQUE <: Opaque](inline x: ZZ) // Methods will be available from root library instead
      /**/       inline def real: Char               = J.unsupportedOperation()
      @tn("Opt") inline def ?   : G.Opt[THIS_OPAQUE] = J.unsupportedOperation()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@class Base -> ### Char Opaque Companion Object Base

  Opaque Base allows to create basic opaque type, which can be recognized and processed by stream without boxing.

  Note. Most opaque companions extend Opaque.Data, which also defines specialized containers attached to the type.

  See [sample type definition](https://github.com/scalqa/samples/blob/master/src/example/opaque/all/OpaqueChar.scala).

@trait _methods -> Default methods for all Char.Opaque.Base defined types

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

     Returns Char value standing behind the opaque type.

     This is a zero cost call.

@def ? ->  To option

    Returns Char specialized option

*/
