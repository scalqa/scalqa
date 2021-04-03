package scalqa; package gen; package util; import language.implicitConversions

trait TwoWayFun[A,B] extends (A => B):
  def apply(v: A) : B
  def undo( v: B) : A

object TwoWayFun:
  /**/            def apply [A,B](af: A => B, bf: B => A) : TwoWayFun[A,B] = new Z.Basic(af,bf)
  /**/            def oneWay[A,B](f:  A => B)             : TwoWayFun[A,B] = new TwoWayFun[A,B] { def apply(a: A) = f(a); def undo(b: B) = J.unsupportedOperation() }
  @tn("getVoid")  def void[A,B]                           : TwoWayFun[A,B] = Z.Void.cast[TwoWayFun[A,B]]
  implicit inline def xxRequest[A,B](inline v: \/)        : TwoWayFun[A,B] = void[A,B]

  extension[A,B](x: TwoWayFun[A,B])
    def reverse: TwoWayFun[B, A] = new Z.Reversed(x)


  private object Z:

    class Basic [A,B](applyFun: A => B, undoFun: B => A) extends TwoWayFun[A,B]:
      def apply(v: A)  = applyFun(v)
      def undo(v: B)   = undoFun(v)

    class Reversed[A,B](val original: TwoWayFun[B, A])  extends TwoWayFun[A,B]:
      def apply(v: A)  = original.undo(v)
      def undo(v: B)   = original.apply(v)

    object Void extends TwoWayFun[Any, Any] with Void:
      def apply(v: Any) = v
      def undo(v: Any)  = v


/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
@trait TwoWayFun -> ### Bi-Directional Function

     [[TwoWayFun]] allows to convert value to some type and back

     It is used in two way binded collections
    ```
       val intToChar: TwoWayFun[Int,Char] = TwoWayFun(i => ('A' + i).toChar, _ - 'A')

       val list:  Idx.M[Int] = Stream(0, 2, 4).toBuffer
       val view:  Idx.M[Char] = list.twoWay_^(intToChar)

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

@def xxRequest -> General void instance request \n\n It is possible to use general request \/ to get void instance of this type, thanks to this implicit conversion.

*/
