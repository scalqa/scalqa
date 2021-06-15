package scalqa; package `val`; package idx; package z; import language.implicitConversions

private[scalqa] object Unsupported_View:

  class O[A](protected val real: Idx[A]) extends J.Util.Proxy.Idx[A] with O.Like[A]

  object O:
    trait Like[A] extends Idx.Observable[A]:
      def onChange[U](l: ><[Observable.Event[A]] => U): Event.Control = \/

    class OM[A](protected val real: Idx.Observable[A]) extends Idx.OM.X.Base[A] with J.Util.Proxy.Idx.O.Basis[A] with Unsupported_View.OM.Like[A]:
      override def onChange[U](l: ><[Observable.Event[A]] => U): Event.Control = real.onChange(l)

  class M[A](protected val real: Idx[A]) extends Idx.Mutable.X.Base[A] with J.Util.Proxy.Idx.Basis[A] with M.Like[A]

  object M:
    trait Like[A] extends Idx.Mutable[A]:
      /**/                def addAt(i: Int, e: A)    : Unit = J.unsupportedOperation()
      /**/                def updateAt(i: Int, e: A) : Unit = J.unsupportedOperation()
      @tn("remove_Range") def remove_<>(r: Int.<>)   : Unit = J.unsupportedOperation()

    class OM[A](protected val real: Idx.Mutable[A]) extends J.Util.Proxy.Idx.M[A] with Unsupported_View.OM.Like[A]:
      /**/                override def addAt(i: Int, e: A)                             : Unit          = real.addAt(i, e)
      /**/                override def updateAt(i: Int, e: A)                          : Unit          = real.update(i, e)
      @tn("remove_Range") override def remove_<>(r: Int.<>)                            : Unit          = real.remove_<>(r)
      /**/                override def modify(ch: Idx.Mutable[A] => Unit)              : Unit          = ch(this)
      /**/                override def onChange[U](l: ><[Observable.Event[A]] => U) : Event.Control = \/

  class OM[A](protected val real: Idx[A]) extends Idx.OM.X.Base[A] with J.Util.Proxy.Idx.Basis[A] with OM.Like[A]

  object OM:
    trait Like[A] extends Idx.ObservableMutable[A] with M.Like[A] with O.Like[A]:
      @tn("refresh_Range") def refresh_<>(r: Int.<>)             : Unit = J.unsupportedOperation()
      /**/                 def modify(ch: Idx.Mutable[A] => Unit): Unit = J.unsupportedOperation()

/*___________________________________________________________________________
    __________ ____   __   ______  ____
   /  __/ ___// _  | / /  / __  / / _  |             Scala Quick API
 __\  \/ /___/ __  |/ /__/ /_/ /_/ __  |   (c) 2021, Scalqa.org Inc
/_____/\____/_/  |_/____/\______/_/  |_|             github.com/scalqa
___________________________________________________________________________*/
