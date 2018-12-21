package scalqa; package Util; package Universal; package Z

private[Universal] object VOID extends Void {

  object Function0 extends (() => Unit) with Void { def apply = () }
  object Function1 extends ((Any) => Unit) with Void { def apply(a: Any) = () }
  object Function2 extends ((Any, Any) => Unit) with Void { def apply(a: Any, b: Any) = () }
  object Function3 extends ((Any, Any, Any) => Unit) with Void { def apply(a: Any, b: Any, c: Any) = () }
  object Function4 extends ((Any, Any, Any, Any) => Unit) with Void { def apply(a: Any, b: Any, c: Any, d: Any) = () }

  object JavaList extends java.util.AbstractList[Nothing] with Void { def get(i: Int) = App.Fail(); def size = 0 }

  object Exception extends Exception("void") with Void

  // ********************************************************
  trait Default {

    implicit def zzScalaList[A](n: \/) = Nil

    implicit def zzFunction1[A](n: \/): A => Any = Function1.asInstanceOf[A => Any]

  }
}
/*___________________________________________________________________________
     __________ ____   __   ______  ____
    /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
  __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2018, Datamata Corporation
 /_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
