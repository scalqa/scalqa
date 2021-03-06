package scalqa; package gen; package util; import language.implicitConversions

trait ReversibleFunction[A,B] extends (A => B):
  def apply(v: A) : B
  def undo( v: B) : A

object ReversibleFunction:
  /**/            def apply [A,B](af: A => B, bf:B => A): ReversibleFunction[A,B] = new Z.Basic(af,bf)
  /**/            def wrap[A,B](f:  A => B)             : ReversibleFunction[A,B] = new ReversibleFunction[A,B] { def apply(a: A) = f(a); def undo(b: B) = J.unsupportedOperation() }
  @tn("getVoid")  def void[A,B]                         : ReversibleFunction[A,B] = Z.Void.cast[ReversibleFunction[A,B]]
  implicit inline def implicitRequest[A,B](inline v: \/): ReversibleFunction[A,B] = void[A,B]

  extension[A,B](x: ReversibleFunction[A,B])
    def reverse: ReversibleFunction[B, A] = new Z.Reversed(x)

  // ****************************************************************************************************
  private object Z:

    class Basic [A,B](applyFun: A => B, undoFun: B => A) extends ReversibleFunction[A,B]:
      def apply(v: A)   = applyFun(v)
      def undo(v: B)    = undoFun(v)

    class Reversed[A,B](val original: ReversibleFunction[B, A])  extends ReversibleFunction[A,B]:
      def apply(v: A)   = original.undo(v)
      def undo(v: B)    = original.apply(v)

    object Void extends ReversibleFunction[Any, Any] with Gen.Void:
      def apply(v: Any) = v
      def undo(v: Any)  = v


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait ReversibleFunction -> ### Bi-Directional Function

     [[ReversibleFunction]] allows to convert value to some type and back

     It is used in two way binded collections
    ```
       val intToChar: ReversibleFunction[Int,Char] = ReversibleFunction(i => ('A' + i).toChar, _ - 'A')

       val list:  Idx.M[Int] = ~~(0, 2, 4).toBuffer
       val view:  Idx.M[Char] = list.mutableMap_^(intToChar)

       list.~.TP     // Prints ~(0, 2, 4)
       view.~.TP     // Prints ~(A, C, E)

       view(1) = 'Z' // Note, only second collection is updated, but both are changed

       list.~.TP     // Prints ~(0, 25, 4)
       view.~.TP     // Prints ~(A, Z, E)
     ```

@def reverse -> Reverses two functions

     `apply` becomes `undo` and `undo` becomes `apply`


@def undo -> Undo map

       Restores conversion result to original value

@def void  -> Get void instance

@def implicitRequest -> General void instance request \n\n It is possible to use general request \\/ to get void instance of this type, thanks to this implicit conversion.

*/
