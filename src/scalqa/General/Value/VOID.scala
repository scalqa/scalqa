package scalqa; package General; package  Value

object VOID extends Value with Void{

  val info: Pipe[(Any, Any)] = ~[(Any, Any)]

  val Function0: (() => Unit) = AnyFunction0
  val Function1: ((Any) => Unit) = AnyFunction1
  val Function2: ((Any, Any) => Unit) = AnyFunction2
  val Function3: ((Any, Any, Any) => Unit) = AnyFunction3
  val Function4: ((Any, Any, Any, Any) => Unit) = AnyFunction4

  import scala.language.implicitConversions

  implicit def zzString(n: VOID.type): String = String.Empty
  implicit def zzException(n: VOID.type): Exception = Exception
  implicit def zzJavaList[A](n: VOID.type): java.util.List[A] = JavaList.cast
  implicit def zzScalaList[A](n: VOID.type) = Nil
  implicit def zzScalaOption[A](n: VOID.type) = None

  implicit def zzFunction0(n: VOID.type): () => Any = AnyFunction0
  implicit def zzFunction1[A](n: VOID.type): A => Any = AnyFunction1.cast
  implicit def zzFunction2[A, B](n: VOID.type): (A, B) => Any = AnyFunction2.cast
  implicit def zzFunction3[A, B, C](n: VOID.type): (A, B, C) => Any = AnyFunction3.cast
  implicit def zzFunction4[A, B, C, D](n: VOID.type): (A, B, C, D) => Any = AnyFunction4.cast

  private object AnyFunction0 extends (() => Unit) with Void { def apply = () }
  private object AnyFunction1 extends ((Any) => Unit) with Void { def apply(a: Any) = () }
  private object AnyFunction2 extends ((Any, Any) => Unit) with Void { def apply(a: Any, b: Any) = () }
  private object AnyFunction3 extends ((Any, Any, Any) => Unit) with Void { def apply(a: Any, b: Any, c: Any) = () }
  private object AnyFunction4 extends ((Any, Any, Any, Any) => Unit) with Void { def apply(a: Any, b: Any, c: Any, d: Any) = () }
  private object JavaList extends Index.Z.Java.Base[Nothing] with Void { def get(i: Int) = Fail(); def size = 0 }
  private object Exception extends Exception("void") with Void

  override def toString = "VOID"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object VOID -> '''General Request VOID'''
 *
 *     See [[General.Value]] for usage
 *
 * @val info -> Empty [[Pipe]]
 *
 *   Void [[Pipe]] of Tuple (Any,Any)
 *
 *   It is used as convenience value for [[Able.Info]]
 *
 * @val Function0 -> Void Function0
 *
 *   Void Function0 defined for [[Any]]
 *
 *   Function does nothing and returns 'Unit'
 *
 * @val Function1 -> Void Function1
 *
 *   Void Function1 defined for [[Any]] parameters
 *
 *   Function does nothing and returns 'Unit'
 *
 * @val Function2 -> Void Function2
 *
 *   Void Function2 defined for [[Any]] parameters
 *
 *   Function does nothing and returns 'Unit'
 *
 * @val Function3 -> Void Function3
 *
 *   Void Function3 defined for [[Any]] parameters
 *
 *   Function does nothing and returns 'Unit'
 *
 * @val Function4 -> Void Function4
 *
 *   Void Function4 defined for [[Any]] parameters
 *
 *   Function does nothing and returns 'Unit'
  */
