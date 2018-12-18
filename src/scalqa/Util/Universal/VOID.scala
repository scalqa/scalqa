package scalqa; package Util; package Universal

object VOID extends Void with Z.VOID.Default {

  implicit def zzString(n: \/): String = ""
  implicit def zzException(n: \/): Exception = Z.VOID.Exception
  implicit def zzJavaList[A](n: \/): java.util.List[A] = Z.VOID.JavaList.asInstanceOf[java.util.List[A]]
  implicit def zzScalaOption[A](n: \/) = None

  implicit def zzFunction0(n: \/): () => Any = Z.VOID.Function0
  implicit def zzFunction1_Param[T[A], A](n: \/): T[A] => Any = Z.VOID.Function1.asInstanceOf[T[A] => Any]
  implicit def zzFunction1_Int(n: \/): Int => Any = Z.VOID.Function1.asInstanceOf[Int => Any]
  //   missing zzFunction1 is in Z.VOID.Default
  implicit def zzFunction2[A, B](n: \/): (A, B) => Any = Z.VOID.Function2.asInstanceOf[(A, B) => Any]
  implicit def zzFunction3[A, B, C](n: \/): (A, B, C) => Any = Z.VOID.Function3.asInstanceOf[(A, B, C) => Any]
  implicit def zzFunction4[A, B, C, D](n: \/): (A, B, C, D) => Any = Z.VOID.Function4.asInstanceOf[(A, B, C, D) => Any]

  implicit def zzIntRange(v: \/): Idx.Range = 0 <>> 0
  implicit def zzShort(v: \/) = 0.toShort
  implicit def zzInt(v: \/) = 0
  implicit def zzLong(v: \/) = 0L
  implicit def zzFloat(v: \/) = 0F
  implicit def zzDouble(v: \/) = 0D

  implicit def zzOrdering[A](v: \/): Ordering[A] = Custom.Ordering.Void.asInstanceOf[Ordering[A]]

  override def toString = "VOID"
}

/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
/**
 * @object VOID -> `Universal Value VOID`
 *
 *     See [[Universal]] for usage
 *
 */
